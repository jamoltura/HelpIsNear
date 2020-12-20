package com.example.helpisnear.classes;

import com.example.helpisnear.enums.TypeResourse;

import java.io.File;
import java.util.ArrayList;

public class UnitMchsResource {

    private TypeResourse typeResourse;
    private UnitResource PdfFile;
    private ArrayList<UnitResource> PngFiles;


    public UnitMchsResource(TypeResourse typeResourse, UnitResource pdfFile, ArrayList<UnitResource> pngFiles) {
        this.typeResourse = typeResourse;
        PdfFile = pdfFile;
        PngFiles = new ArrayList<>(pngFiles);
    }

    public UnitMchsResource(TypeResourse typeResourse, UnitResource pdfFile) {
        this.typeResourse = typeResourse;
        PdfFile = pdfFile;
        PngFiles = new ArrayList<>();
    }

    public TypeResourse getTypeResourse() {
        return typeResourse;
    }

    public void setTypeResourse(TypeResourse typeResourse) {
        this.typeResourse = typeResourse;
    }

    public UnitResource getPdfFile() {
        return PdfFile;
    }

    public void setPdfFile(UnitResource pdfFile) {
        PdfFile = pdfFile;
    }

    public ArrayList<UnitResource> getPngFiles() {
        return PngFiles;
    }

    public void setPngFiles(ArrayList<UnitResource> pngFiles) {
        PngFiles = pngFiles;
    }
}
