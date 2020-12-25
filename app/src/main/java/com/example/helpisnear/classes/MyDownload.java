package com.example.helpisnear.classes;

import android.content.Context;
import android.util.Log;

import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.helpisnear.enums.StateDownload;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MyDownload {

    private static final String TAG = "myLogs";

    private static MyDownload myDownload;
    private StateDownload stateDownload;
    private Callback callback;

    public interface Callback{
        void callingBack();
    }

    private ArrayList<UnitResource> list;

    public static MyDownload getInstanse(){
        if (myDownload == null){
            myDownload = new MyDownload();
            myDownload.setStateDownload(StateDownload.NON_DOWNLOAD);
        }
        return myDownload;
    }

    private MyDownload() {
        list = new ArrayList<>();
    }

    public boolean add(UnitResource unitResource){
        if (getStateDownload() == StateDownload.NON_DOWNLOAD || getStateDownload() == StateDownload.YES_DOWNLOAD) {
            stateDownload = StateDownload.YES_DOWNLOAD;
            list.add(unitResource);
            return true;
        }
        return false;
    }

    public void registerCallBack(Callback callback){
        this.callback = callback;
    }

    public void startDownload(Context context){

        if (stateDownload == StateDownload.YES_DOWNLOAD) {

            stateDownload = StateDownload.START_DOWNLOAD;

            Constraints constraints = new Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build();

            OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWerker.class)
                    .setBackoffCriteria(
                            BackoffPolicy.LINEAR,
                            1,
                            TimeUnit.MILLISECONDS)
                    .setConstraints(constraints)
                    .build();

            WorkManager.getInstance(context.getApplicationContext())
                    .enqueueUniqueWork("download", ExistingWorkPolicy.APPEND_OR_REPLACE, workRequest);
        }
    }

    public ArrayList<UnitResource> getList() {
        return list;
    }

    public StateDownload getStateDownload() {
        return stateDownload;
    }

    public void setStateDownload(StateDownload stateDownload) {
        if (stateDownload == StateDownload.COMPILE_DOWNLOAD){
            list.clear();
            this.stateDownload = StateDownload.NON_DOWNLOAD;
            callback.callingBack();

        }else {
            this.stateDownload = stateDownload;
        }
    }
}
