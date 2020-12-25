package com.example.helpisnear.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.helpisnear.R;
import com.example.helpisnear.classes.BaseActivity;
import com.example.helpisnear.classes.DownloadManagerResolver;
import com.example.helpisnear.classes.MyDownload;
import com.example.helpisnear.model.HomeViewModel;
import com.example.helpisnear.ui_info.window_test.WindowTestFragment;

import android.os.Bundle;
import android.view.MenuItem;

public class WindowTestActivity extends BaseActivity implements MyDownload.Callback{

    private HomeViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MenuItem item_update = navigationView.getMenu().findItem(R.id.update);
        item_update.setOnMenuItemClickListener(item -> {
            drawer.closeDrawers();

            if (DownloadManagerResolver.resolve(getApplicationContext())) {
                mViewModel.update(getApplicationContext());
                MyDownload.getInstanse().registerCallBack(getActivi());
                MyDownload.getInstanse().startDownload(getApplicationContext());
            }

            return true;
        });

        String position = getIntent().getStringExtra("position");

        Bundle bundle = new Bundle();
        bundle.putString("position", position);

        WindowTestFragment windowTestFragment = new WindowTestFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, windowTestFragment)
                .commit();

        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        mViewModel.init(getApplicationContext());

        if (DownloadManagerResolver.resolve(getApplicationContext())) {
            MyDownload.getInstanse().registerCallBack(this);
            MyDownload.getInstanse().startDownload(getApplicationContext());
        }

    }

    private WindowTestActivity getActivi(){
        return this;
    }

    @Override
    public void callingBack() {
        mViewModel.update(getApplicationContext());
    }
}