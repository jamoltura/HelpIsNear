package com.example.helpisnear.activites;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.lifecycle.ViewModelProviders;

import com.example.helpisnear.R;
import com.example.helpisnear.classes.BaseActivity;
import com.example.helpisnear.classes.DownloadManagerResolver;
import com.example.helpisnear.classes.MyDownload;
import com.example.helpisnear.model.HomeViewModel;
import com.example.helpisnear.ui_info.first_aid_yes.FirstAidYesFragment;

public class FirstAidYesActivity extends BaseActivity implements MyDownload.Callback {

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

        FirstAidYesFragment firstAidYesFragment = FirstAidYesFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, firstAidYesFragment)
                .commit();

        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        mViewModel.init(getApplicationContext());

        if (DownloadManagerResolver.resolve(getApplicationContext())) {
            MyDownload.getInstanse().registerCallBack(this);
            MyDownload.getInstanse().startDownload(getApplicationContext());
        }

    }

    private FirstAidYesActivity getActivi(){
        return this;
    }

    @Override
    public void callingBack() {
        mViewModel.update(getApplicationContext());
    }
}