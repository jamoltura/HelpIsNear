package com.example.helpisnear.classes;

import android.content.Context;

import com.example.helpisnear.R;
import com.example.helpisnear.enums.MyLanguage;
import com.example.helpisnear.enums.TypeResourse;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

public class MchsResource {

    private static final String TAG = "myLogs";

    private DefaultMchsResource defaultMchsResource;
    private ArrayList<String> PdfFileName;
    private ArrayList<String> PngFileName;

    private ArrayList<String> listPdfFileName;
    private ArrayList<String> listPngFileName;

    public MchsResource(Context context) {

        FileManager fileManager = new FileManager(context);

        PdfFileName = fileManager.getListFilesNamePdf();
        PngFileName = fileManager.getListFilesNamePng();

        listPdfFileName = fileManager.getListFilesPdf();
        listPngFileName = fileManager.getListFilesPng();

        defaultMchsResource = new DefaultMchsResource(getlanguage(context));

    }

    public ArrayList<UnitMchsResource> getMchsResources_WhatToDo(){

        ArrayList<UnitMchsResource> list = defaultMchsResource.getUnitMchsResources_WhatToDo();

        int count = list.size();

        if (count > 0){
            for (int i = 0; i < count; i++){
                builder(list.get(i));
            }
        }

        return list;
    }

    public ArrayList<UnitMchsResource> getMchsResources_FirstAid(){

        ArrayList<UnitMchsResource> list = defaultMchsResource.getUnitMchsResources_FirstAid();

        int count = list.size();

        if (count > 0){
            for (int i = 0; i < count; i++){
                builder(list.get(i));
            }
        }

        return list;
    }

    public ArrayList<UnitMchsResource> getMchsResources_Encyclopedia(){

        ArrayList<UnitMchsResource> list = defaultMchsResource.getUnitMchsResources_Encyclopedia();

        int count = list.size();

        if (count > 0){
            for (int i = 0; i < count; i++){
                builder(list.get(i));
            }
        }

        return list;
    }

    public ArrayList<UnitMchsResource> getMchsResources_InformationAndSettings(){

        ArrayList<UnitMchsResource> list = defaultMchsResource.getUnitMchsResources_InformationAndSettings();

        int count = list.size();

        if (count > 0){
            for (int i = 0; i < count; i++){
                builder(list.get(i));
            }
        }

        return list;
    }

    private void builder(UnitMchsResource resource){
        builderPdf(resource, PdfFileName);
        if (resource.getTypeResourse() == TypeResourse.PDF_PNG) {
            builderPng(resource, PngFileName);
        }
    }

    private void builderPdf(UnitMchsResource resource, ArrayList<String> list){
        int count = list.size();

        if (count > 0){
            for (int i = 0; i < count; i++){
                String name = list.get(i);
                if (resource.getPdfFile().getFileName().equals(name)){
                    String path = listPdfFileName.get(i);
                    File file = new File(path);
                    resource.getPdfFile().setFile(file);
                    resource.getPdfFile().setExists(true);
                    break;
                }
            }
        }
        if (!resource.getPdfFile().isExists()){
            MyDownload myDownload = MyDownload.getInstanse();
            myDownload.add(resource.getPdfFile());
        }
    }

    private void builderPng(UnitMchsResource resource, ArrayList<String> list){
        int count = list.size();
        int countPng = resource.getPngFiles().size();

        boolean file_exists = false;

        if (count > 0){
            for (int i = 0; i < count; i++){
                String name = list.get(i);
                for (int j = 0; j < countPng; j++) {
                    if (resource.getPngFiles().get(j).getFileName().equals(name)) {
                        String path = listPngFileName.get(i);
                        File file = new File(path);
                        file_exists = file.exists();
                        resource.getPngFiles().get(j).setFile(file);
                        resource.getPngFiles().get(j).setExists(true);
                        break;
                    }
                }
                if (file_exists){
                    break;
                }
            }
        }
        MyDownload myDownload = MyDownload.getInstanse();
        for (int i = 0; i < countPng; i++){
            if (!resource.getPngFiles().get(i).isExists()){
                myDownload.add(resource.getPngFiles().get(i));
            }
        }
    }

    private MyLanguage getlanguage(Context context){
        String lang = LocaleHelper.getLanguage(context.getApplicationContext());
        switch (lang){
            case "ru" : return MyLanguage.RU;
            case "en" : return MyLanguage.EN;
            case "uz" : return MyLanguage.UZ_LT;
            default : return MyLanguage.UZ_KR;
        }
    }
}
