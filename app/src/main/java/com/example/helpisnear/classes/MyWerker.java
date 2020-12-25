package com.example.helpisnear.classes;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.*;

import com.example.helpisnear.enums.StateDownload;
import com.example.helpisnear.enums.TypeFile;
import com.example.helpisnear.model.HomeViewModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.content.Context.DOWNLOAD_SERVICE;

public class MyWerker extends Worker {

    private static final String TAG = "myLogs";
    private Context context;
    private HashMap<Long, File> listIdDownload;

    public MyWerker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {

        MyDownload.getInstanse().setStateDownload(StateDownload.DOWNLOADED);

        int count = MyDownload.getInstanse().getList().size();

        if (count > 0) {

            IntentFilter filter = new IntentFilter();
            filter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
            filter.addAction(DownloadManager.ACTION_VIEW_DOWNLOADS);

            context.registerReceiver(DownloadReceiver, filter);

            ArrayList<UnitResource> list = MyDownload.getInstanse().getList();
            listIdDownload = new HashMap<>();

            for (int i =0; i < count; i++) {
                downloadFile(list.get(i));
            }
        }else {
            MyDownload.getInstanse().setStateDownload(StateDownload.NON_DOWNLOAD);
        }

        return Result.success();
    }

    @Override
    public void onStopped() {
        super.onStopped();
        context.unregisterReceiver(DownloadReceiver);
    }

    private void downloadFile(UnitResource unitResource){

        String link = unitResource.getInetAdress();
        String name = unitResource.getFileName();
        String path = "";

        if (unitResource.getTypeFile() == TypeFile.PDF) {
            path = FileManager.getFilesPdfPath(context);
        }else {
            path = FileManager.getFilesPngPath(context);
        }

        DownloadManager dm = (DownloadManager) context.getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(android.net.Uri.parse(link));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setAllowedOverRoaming(false);
        request.setTitle("Downloading");
        request.setDescription("Downloading File");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);

        request.setDestinationInExternalFilesDir(context, path, name);

        try {
            Long id = dm.enqueue(request);
            File file = new File(path, name);
            listIdDownload.put(id, file);
        }catch (NullPointerException e){
            Log.d(TAG, "NullPointerException : " + e);
        }
    }

    private void copy(InputStream in, File target) throws IOException {

        OutputStream out = new FileOutputStream(target);

        byte[] buf = new byte[1024];
        int len;

        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        out.flush();
        out.close();
    }

    public HashMap<Long, File> getListIdDownload() {
        return listIdDownload;
    }

    private final BroadcastReceiver DownloadReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(intent.getAction())) {

                long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);

                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(id);
                DownloadManager dm = (DownloadManager) context.getSystemService(DOWNLOAD_SERVICE);
                Cursor c = dm.query(query);

                if (c.moveToFirst()) {

                    int columnIndex = c.getColumnIndex(DownloadManager.COLUMN_STATUS);

                    if (DownloadManager.STATUS_SUCCESSFUL == c.getInt(columnIndex)) {

                        HashMap<Long, File> list = new HashMap<>(getListIdDownload());

                        for (Map.Entry<Long, File> item : list.entrySet()) {
                            if (id == item.getKey()){

                                try {
                                    InputStream streamfile = new FileInputStream(dm.openDownloadedFile(id).getFileDescriptor());

                                    copy(streamfile, item.getValue());

                                    dm.remove(id);

                                } catch (IOException e) {
                                    Log.d(TAG, e.getMessage());
                                }

                                getListIdDownload().remove(id);
                                Toast.makeText(context, "Загрузка завершена", Toast.LENGTH_LONG).show();
                                break;
                            }
                        }

                    } else if (DownloadManager.STATUS_FAILED == c.getInt(columnIndex)) {
                        getListIdDownload().remove(id);
                        Toast.makeText(context, "Ошибка при загрузке !!!", Toast.LENGTH_LONG).show();
                    } else if (DownloadManager.STATUS_RUNNING == c.getInt(columnIndex)) {
                        Toast.makeText(context, "Загрузка началась", Toast.LENGTH_LONG).show();
                    }
                }

                if (getListIdDownload().size() == 0){
                    MyDownload.getInstanse().setStateDownload(StateDownload.COMPILE_DOWNLOAD);
                }
            }
        }
    };
}
