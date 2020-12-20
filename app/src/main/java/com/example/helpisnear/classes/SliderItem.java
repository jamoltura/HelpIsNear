package com.example.helpisnear.classes;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.helpisnear.R;

import java.util.ArrayList;

public class SliderItem {

    private final String path;
    private int index;
    private Resources res;

    public SliderItem(Resources res, String path, int value) {
        this.res = res;
        this.path = path;
        setIndex(value);
    }

    public Bitmap getImageUrl(){
        if (!path.isEmpty()) {
            return BitmapFactory.decodeFile(path);
        }else {
            return BitmapFactory.decodeResource(res, R.drawable.mchs);
        }
    }

    public String getPath() {
        return path;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
