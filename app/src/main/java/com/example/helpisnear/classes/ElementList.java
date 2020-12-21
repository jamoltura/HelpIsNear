package com.example.helpisnear.classes;

public class ElementList {

    private final int idDrawable;
    private final int idString;


    public ElementList(int idDrawable, int idString) {
        this.idDrawable = idDrawable;
        this.idString = idString;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getIdString() {
        return idString;
    }
}
