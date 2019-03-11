package com.example.ismael.m08_retrofit_glide;

import java.io.Serializable;

public class Photo implements Serializable {
    public int id;
    public String author;
    public String filename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


}