package com.example.cs2pj20springcoursework;

import android.view.View;
import android.widget.TextView;

public class NewsCell {

    private int imageResource;
    private String title;
    private String date;
    private String description;

    public NewsCell(int imageResource, String title, String date, String description){
        this.imageResource = imageResource;
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
