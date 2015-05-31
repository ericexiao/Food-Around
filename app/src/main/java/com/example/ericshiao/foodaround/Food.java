package com.example.ericshiao.foodaround;


import java.text.DecimalFormat;

/**
 * Created by Eric on 1/28/2015.
 */

/*
Java class that defines fooditems that go on the menus.
 */
public class Food {
    int id; //identification tag on the database
    String name; //name of the fooditem (on the menu)
    String price;
    int speciality; //is this considered a popular or specialty item of the restaurant
    int rating; //currently restricted to thumbs up or thumbs down or none
    int eaten;
    String description;
    String courseType; //appetizer, entree, etc.

    public Food(int id, String name, String price, int speciality, int rating, int eaten, String description, String courseType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.speciality = speciality;
        this.rating = rating;
        this.eaten = eaten;
        this.description = description;
        this.courseType = courseType;
    }


}
