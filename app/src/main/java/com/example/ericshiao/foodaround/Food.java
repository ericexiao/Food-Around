package com.example.ericshiao.foodaround;


import java.text.DecimalFormat;

/**
 * Created by Eric on 1/28/2015.
 */

/*
Java class that defines fooditems that go on the menus.
 */
public class Food {
    private String name;
    private String price;
    private int speciality;
    private int rating;
    private int eaten;
    private String description;
    private String courseType;

    public Food(String name, String price, int speciality, int rating, int eaten, String description, String courseType) {
        this.name = name;
        this.price = price;
        this.speciality = speciality;
        this.rating = rating;
        this.eaten = eaten;
        this.description = description;
        this.courseType = courseType;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getEaten() {
        return eaten;
    }

    public int getRating() {
        return rating;
    }

    public int getSpeciality() {
        return speciality;
    }

    public String getCourseType() {
        return courseType;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEaten(int eaten) {
        this.eaten = eaten;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setSpeciality(int speciality) {
        this.speciality = speciality;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
