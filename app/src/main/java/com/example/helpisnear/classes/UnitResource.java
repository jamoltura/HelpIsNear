package com.example.helpisnear.classes;

import android.content.Context;

import java.io.File;
import com.example.helpisnear.R;
import com.example.helpisnear.enums.TypeFile;

public class UnitResource {

    private final String DOWNLOAD_SERVICE = "https://getfile.dokpub.com/yandex/get/";

    private final TypeFile typeFile;
    private final String fileName;
    private final String inetAdress;
    private String localAdress;
    private File file;
    private boolean exists;


    public UnitResource(TypeFile typeFile, String fileName, String inetAdress) {
        this.typeFile = typeFile;
        this.fileName = fileName;
        this.inetAdress = DOWNLOAD_SERVICE + inetAdress;
        setLocalAdress("");
        setExists(false);
    }

    public String getFileName() {
        return fileName;
    }

    public String getInetAdress() {
        return inetAdress;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getLocalAdress() {
        return localAdress;
    }

    public void setLocalAdress(String localAdress) {
        this.localAdress = localAdress;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public TypeFile getTypeFile() {
        return typeFile;
    }
}
