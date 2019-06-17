package com.example.tamarapuspa.bunny1;

public class modelJenisPenyakit {

    String title, description, image; //these name must match with the names in firebase database

    //constructor
    public modelJenisPenyakit(){}

    //getter and setters

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
