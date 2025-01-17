package com.example.helpisnear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.helpisnear.classes.ListResource;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListResource.getInstance();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}