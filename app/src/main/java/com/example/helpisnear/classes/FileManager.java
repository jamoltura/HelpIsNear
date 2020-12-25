package com.example.helpisnear.classes;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

public class FileManager {

    private static final String TAG = "myLogs";

    // Поный пут к приложении ////////////
    private String pathApp;

    // Полный пут к папкам PDF ////////////////
    private String pathFilesPdf;

    // Полный пут к папкам Png ////////////////
    private String pathFilesPng;

    //  Свойства File Path  /////////////////////////
    private ArrayList<String> listFilesPdf= new ArrayList<String>();
    private ArrayList<String> listFilesPng= new ArrayList<String>();

    //  Свойства File name   /////////////////////////
    private ArrayList<String> listFilesNamePdf= new ArrayList<String>();
    private ArrayList<String> listFilesNamePng= new ArrayList<String>();

    public FileManager(Context context) {
        setPathApp(context.getFilesDir().getAbsolutePath());
        init();
    }

    public static String getFilesPdfPath(Context context){
        return context.getFilesDir().getAbsolutePath() + "/FilesPdf";
    }

    public static String getFilesPngPath(Context context){
        return context.getFilesDir().getAbsolutePath() + "/FilesPng";
    }

    private void init(){

        pathFilesPdf = _addDirectory(getPathApp() + getDirFilesPdf());
        pathFilesPng = _addDirectory(getPathApp() + getDirFilesPng());

        if (IsDirectory(getPathFilesPdf())){
            listFilePdf();
        }

        if (IsDirectory(getPathFilesPng())){
            listFilePng();
        }
    }

    private String _addDirectory(String value) throws SecurityException{
        if (IsDirectory(value)) {
            return value;
        }
        return "";
    }

    private Boolean IsDirectory(String value) throws SecurityException{
        File theDirTemp = new File(value);
        if (!theDirTemp.exists()) {
            theDirTemp.mkdir();
        }
        return theDirTemp.exists();
    }

    /////////////////
    //  File Pdf
    /////////////////

    private void listFilePdf() {

        listFilesPdf.clear();

        int count = countFilePdf();

        for (int i = 0; count > i; i++) {
            listFilesPdf.add(get_FilePath(getPathFilesPdf(), i));
            listFilesNamePdf.add(get_FileName(getPathFilesPdf(), i));
        }
    }

    private int countFilePdf(){
        return countFile(getPathFilesPdf());
    }

    /////////////////
    //  File Png
    /////////////////

    private void listFilePng() {

        listFilesPng.clear();

        int count = countFilePng();

        for (int i = 0; count > i; i++) {
            listFilesPng.add(get_FilePath(getPathFilesPng(), i));
            listFilesNamePng.add(get_FileName(getPathFilesPng(), i));
        }
    }

    private int countFilePng(){
        return countFile(getPathFilesPng());
    }

    /////////////////////////// private functions ///////////////////////////

    private String get_FilePath(String put, int ind) {

        File file = new File(put);
        File[] files = file.listFiles();

        try {
            if (files[ind].isFile()) {
                return files[ind].getAbsolutePath();
            }
        } catch (Exception e) {
            Log.d(TAG, "Exception error : " + e.getMessage());
        }
        return null;
    }

    private String get_FileName(String put, int ind) {

        File file = new File(put);
        File[] files = file.listFiles();

        try {
            if (files[ind].isFile()) {
                return files[ind].getName();
            }
        } catch (Exception e) {
            Log.d(TAG, "Exception error : " + e.getMessage());
        }
        return null;
    }

    private int countFile(String value){
        File file = new File(value);
        File[] files = file.listFiles();
        return files.length;
    }

    private String getPathApp() {
        return pathApp;
    }

    private void setPathApp(String pathApp) {
        this.pathApp = pathApp;
    }

    private String getDirFilesPdf(){
        return "/FilesPdf";
    }

    private String getDirFilesPng(){
        return "/FilesPng";
    }

    private String getPathFilesPdf() {
        return pathFilesPdf;
    }

    private void setPathFilesPdf(String pathFilesPdf) {
        this.pathFilesPdf = pathFilesPdf;
    }

    private String getPathFilesPng() {
        return pathFilesPng;
    }

    private void setPathFilesPng(String pathFilesPng) {
        this.pathFilesPng = pathFilesPng;
    }

    public ArrayList<String> getListFilesPdf() {
        return listFilesPdf;
    }

    private void setListFilesPdf(ArrayList<String> listFilesPdf) {
        this.listFilesPdf = listFilesPdf;
    }

    public ArrayList<String> getListFilesPng() {
        return listFilesPng;
    }

    private void setListFilesPng(ArrayList<String> listFilesPng) {
        this.listFilesPng = listFilesPng;
    }

    public ArrayList<String> getListFilesNamePdf() {
        return listFilesNamePdf;
    }

    private void setListFilesNamePdf(ArrayList<String> listFilesNamePdf) {
        this.listFilesNamePdf = listFilesNamePdf;
    }

    public ArrayList<String> getListFilesNamePng() {
        return listFilesNamePng;
    }

    private void setListFilesNamePng(ArrayList<String> listFilesNamePng) {
        this.listFilesNamePng = listFilesNamePng;
    }
}
