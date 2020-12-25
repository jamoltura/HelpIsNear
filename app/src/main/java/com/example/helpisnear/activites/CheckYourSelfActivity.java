package com.example.helpisnear.activites;

import com.example.helpisnear.R;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.lifecycle.ViewModelProviders;

import com.example.helpisnear.classes.BaseActivity;
import com.example.helpisnear.classes.DownloadManagerResolver;
import com.example.helpisnear.classes.MyDownload;
import com.example.helpisnear.model.HomeViewModel;
import com.example.helpisnear.ui_info.check_your.CheckYourFragment;

public class CheckYourSelfActivity extends BaseActivity implements MyDownload.Callback{

    private HomeViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViewById(R.id.btn_call_info).setVisibility(View.INVISIBLE);

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
        String header = getIntent().getStringExtra("header");

        Bundle bundle = new Bundle();
        bundle.putString("position", position);
        bundle.putString("header", header);

        CheckYourFragment checkYourFragment = CheckYourFragment.newInstance();

        checkYourFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, checkYourFragment)
                .commit();

        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        mViewModel.init(getApplicationContext());
    }

    private CheckYourSelfActivity getActivi(){
        return this;
    }

    @Override
    public void callingBack() {
        mViewModel.update(getApplicationContext());
    }
}