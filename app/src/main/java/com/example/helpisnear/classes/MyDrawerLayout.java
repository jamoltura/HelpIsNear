package com.example.helpisnear.classes;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MyDrawerLayout extends DrawerLayout {
    public MyDrawerLayout(@NonNull Context context) {
        super(context);
    }

    public MyDrawerLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyDrawerLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void close() {
        closeDrawer(GravityCompat.END);
    }

    @Override
    public void open() {
        openDrawer(GravityCompat.END);
    }
}
