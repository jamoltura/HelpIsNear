package com.example.helpisnear.classes;

import java.util.ArrayList;

public class MyDownload {

    private static final String TAG = "myLogs";

    private static MyDownload myDownload;

    private ArrayList<UnitResource> list;

    public static MyDownload getInstanse(){
        if (myDownload == null){
            myDownload = new MyDownload();
        }
        return myDownload;
    }

    private MyDownload() {
        list = new ArrayList<>();
    }

    public void add(UnitResource unitResource){
        list.add(unitResource);
    }
}
