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
        MyDownload.getInstanse().getList().clear();
    }

    public ArrayList<UnitMchsResource> getMchsResources_WhatToDo(){

        ArrayList<UnitMchsResource> list = defaultMchsResource.getUnitMchsResources_WhatToDo();

        int count = list.size();

        if (count > 0){
            for (int i = 0; i < count; i++){
                builderPdf(list.get(i).getPdfFile(), PdfFileName);
                if (list.get(i).getTypeResourse() == TypeResourse.PDF_PNG) {
                    builderPng(list.get(i).getPngFiles(), PngFileName);
                }
            }
        }

        return list;
    }

    public ArrayList<UnitMchsResource> getMchsResources_FirstAid(){

        ArrayList<UnitMchsResource> list = defaultMchsResource.getUnitMchsResources_FirstAid();

        int count = list.size();

        if (count > 0){
            for (int i = 0; i < count; i++){
                builderPdf(list.get(i).getPdfFile(), PdfFileName);
                if (list.get(i).getTypeResourse() == TypeResourse.PDF_PNG) {
                    builderPng(list.get(i).getPngFiles(), PngFileName);
                }
            }
        }

        return list;
    }

    public ArrayList<UnitMchsResource> getMchsResources_Encyclopedia(){

        ArrayList<UnitMchsResource> list = defaultMchsResource.getUnitMchsResources_Encyclopedia();

        int count = list.size();

        if (count > 0){
            for (int i = 0; i < count; i++){
                builderPdf(list.get(i).getPdfFile(), PdfFileName);
                if (list.get(i).getTypeResourse() == TypeResourse.PDF_PNG) {
                    builderPng(list.get(i).getPngFiles(), PngFileName);
                }
            }
        }

        return list;
    }

    public ArrayList<UnitMchsResource> getMchsResources_InformationAndSettings(){

        ArrayList<UnitMchsResource> list = defaultMchsResource.getUnitMchsResources_InformationAndSettings();

        int count = list.size();

        if (count > 0){
            for (int i = 0; i < count; i++){
                builderPdf(list.get(i).getPdfFile(), PdfFileName);
                if (list.get(i).getTypeResourse() == TypeResourse.PDF_PNG) {
                    builderPng(list.get(i).getPngFiles(), PngFileName);
                }
            }
        }

        return list;
    }

    private void builderPdf(UnitResource resource, ArrayList<String> list){
        int count = list.size();

        if (count > 0){

            for (int i = 0; i < count; i++){
                String name = list.get(i);
                if (resource.getFileName().equals(name)){
                    String path = listPdfFileName.get(i);
                    File file = new File(path);

                    if (file.exists()) {
                        resource.setFile(file);
                        resource.setLocalAdress(file.getAbsolutePath());
                        resource.setExists(true);
                    }
                    break;
                }
            }
        }
        if (!resource.isExists()){
            MyDownload.getInstanse().add(resource);
        }
    }

    private void builderPng(ArrayList<UnitResource> resource, ArrayList<String> list){
        int count = list.size();
        int countPng = resource.size();

        if (count > 0){

            for (int i = 0; i < count; i++){

                String name = list.get(i);

                int countPngSuccess = 0;
                for (int j = 0; j < countPng; j++) {
                    if (resource.get(j).getFileName().equals(name)) {
                        countPngSuccess++;
                        String path = listPngFileName.get(i);
                        File file = new File(path);

                        if (file.exists()) {
                            resource.get(j).setFile(file);
                            resource.get(j).setLocalAdress(file.getAbsolutePath());
                            resource.get(j).setExists(true);
                        }
                    }
                }
                if (countPngSuccess == countPng){
                    break;
                }
            }
        }
        MyDownload myDownload = MyDownload.getInstanse();
        for (int i = 0; i < countPng; i++){
            if (!resource.get(i).isExists()){
                myDownload.add(resource.get(i));
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
