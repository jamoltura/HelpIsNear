package com.example.helpisnear.activites;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.lifecycle.ViewModelProviders;

import com.example.helpisnear.R;
import com.example.helpisnear.classes.BaseActivity;
import com.example.helpisnear.classes.DownloadManagerResolver;
import com.example.helpisnear.classes.MyDownload;
import com.example.helpisnear.model.HomeViewModel;
import com.example.helpisnear.ui_info.info.InfoFragment;
import com.example.helpisnear.ui_info.info.SetCallBtnFragment;
import com.example.helpisnear.ui_info.info.SettingLangFragment;

public class InfoActivity extends BaseActivity implements MyDownload.Callback{

    private HomeViewModel mViewModel;

    private InfoFragment infoFragment;
    private SettingLangFragment settingLangFragment;
    private SetCallBtnFragment setCallBtnFragment;

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

        String action = getIntent().getStringExtra("type_info");
        String position = getIntent().getStringExtra("position");

        if (action.equals("WhatToDo") || action.equals("FirstAid") || action.equals("Encyclopedia") || action.equals("InfAndSettings")){

            Bundle bundle = new Bundle();
            bundle.putString("type_info", action);
            bundle.putString("position", position);

            infoFragment = InfoFragment.newInstance();

            infoFragment.setArguments(bundle);

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, infoFragment)
                    .commit();
        }else if (action.equals("SettingsLang")){

            settingLangFragment = SettingLangFragment.newInstance();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, settingLangFragment)
                    .commit();
        }else if (action.equals("SetCallBtn")){

            setCallBtnFragment = SetCallBtnFragment.newInstance();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, setCallBtnFragment)
                    .commit();
        }

        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        mViewModel.init(getApplicationContext());

        if (DownloadManagerResolver.resolve(getApplicationContext())) {
            MyDownload.getInstanse().registerCallBack(this);
            MyDownload.getInstanse().startDownload(getApplicationContext());
        }
    }

    private InfoActivity getActivi(){
        return this;
    }

    @Override
    public void callingBack() {
        mViewModel.update(getApplicationContext());
    }
}