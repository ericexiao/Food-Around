package com.example.ericshiao.foodaround;


import java.text.DecimalFormat;

/**
 * Created by Eric on 1/28/2015.
 */

/*
Java class that defines fooditems that go on the menus.
 */
public class Food {
    String name;
    String price;
    int speciality;
    int rating;
    int eaten;
    String description;
    String courseType;

    public Food(String name, String price, int speciality, int rating, int eaten, String description, String courseType) {
        this.name = name;
        this.price = price;
        this.speciality = speciality;
        this.rating = rating;
        this.eaten = eaten;
        this.description = description;
        this.courseType = courseType;
    }


}
