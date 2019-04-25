package com.example.a533.exercice_android_cours_13;

import java.util.Date;

public class ToDo {

    Date dateAdded;
    String title;
    String description;


    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ToDo(Date dateAdded, String title, String description) {
        this.dateAdded = dateAdded;
        this.title = title;
        this.description = description;
    }
}
