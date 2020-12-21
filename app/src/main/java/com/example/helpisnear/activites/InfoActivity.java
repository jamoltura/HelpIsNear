package com.example.helpisnear.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.app.FragmentContainer;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.helpisnear.R;
import com.example.helpisnear.classes.DialogCall;
import com.example.helpisnear.classes.LocaleHelper;
import com.example.helpisnear.classes.MyDrawerLayout;
import com.example.helpisnear.model.HomeViewModel;
import com.example.helpisnear.ui.info.InfoFragment;
import com.example.helpisnear.ui.info.SetCallBtnFragment;
import com.example.helpisnear.ui.info.SettingLangFragment;
import com.google.android.material.navigation.NavigationView;

public class InfoActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";

    private HomeViewModel mViewModel;


    private MyDrawerLayout drawer;
    private NavigationView navigationView;
    private SearchView searchView;

    private InfoFragment infoFragment;
    private SettingLangFragment settingLangFragment;
    private SetCallBtnFragment setCallBtnFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String lang = LocaleHelper.getLanguage(getApplicationContext());
        LocaleHelper.onAttach(this, lang);

        setContentView(R.layout.activity_info);

        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        mViewModel.init(getApplicationContext());

        Toolbar toolbar = findViewById(R.id.toolbar_info);
        setSupportActionBar(toolbar);

        ImageView img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });

        ImageView img_menu = (ImageView) findViewById(R.id.img_menu);
        img_menu.setOnClickListener((v -> drawer.open()));

        searchView = findViewById(R.id.search_view_info);

        ImageButton btn_call = findViewById(R.id.btn_call_info);
        btn_call.setOnClickListener((v -> getSupportFragmentManager()
                .beginTransaction()
                .add(new DialogCall(), "dialogCall")
                .commit()));

        drawer = findViewById(R.id.drawer_layout_info);

        navigationView = findViewById(R.id.nav_view_info);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int result = -1;

                switch (item.getItemId()){
                    case R.id.nav_home : result = 0;
                        break;
                    case R.id.whatToDoFragment : result = 1;
                        break;
                    case R.id.firstAidFragment : result = 2;
                        break;
                    case R.id.mapOfAdverseEventsFragment : result = 3;
                        break;
                    case R.id.checkYourSelfFragment : result = 4;
                        break;
                    case R.id.encyclopediaFragment : result = 5;
                        break;
                    case R.id.informationAndSettingsFragment : result = 6;
                }

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", result);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();

                return true;
            }
        });

        String action = getIntent().getStringExtra("type_info");
        String position = getIntent().getStringExtra("position");

        if (action.equals("WhatToDo") || action.equals("FirstAid") || action.equals("Encyclopedia") || action.equals("InfAndSettings")){

            Bundle bundle = new Bundle();
            bundle.putString("type_info", action);
            bundle.putString("position", position);

            infoFragment = new InfoFragment();

            infoFragment.setArguments(bundle);

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, infoFragment)
                    .commit();
        }else if (action.equals("SettingsLang")){

            settingLangFragment = new SettingLangFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, settingLangFragment)
                    .commit();
        }else if (action.equals("SetCallBtn")){

            setCallBtnFragment = new SetCallBtnFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, setCallBtnFragment)
                    .commit();
        }
    }
}