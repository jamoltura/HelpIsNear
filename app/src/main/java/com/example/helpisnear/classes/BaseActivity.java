package com.example.helpisnear.classes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.helpisnear.R;
import com.google.android.material.navigation.NavigationView;

public abstract class BaseActivity extends AppCompatActivity{

    protected static final String TAG = "myLogs";

    protected MyDrawerLayout drawer;
    protected NavigationView navigationView;
    protected SearchView searchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String lang = LocaleHelper.getLanguage(getApplicationContext());
        LocaleHelper.onAttach(this, lang);

        setContentView(R.layout.activity_info);

        Toolbar toolbar = findViewById(R.id.toolbar_info);
        setSupportActionBar(toolbar);

        ImageView img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(v -> {
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();
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

        navigationView.setNavigationItemSelectedListener(item -> {

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
        });
    }
}
