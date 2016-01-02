package com.example.ericshiao.foodaround;

import android.media.Image;
import android.text.format.Time;

import java.util.ArrayList;

/**
 * Created by Eric on 1/4/2015.
 */
public class Restaurant {
    //restaurant variables
    String name;
    String address;
    String genLocation;
    ArrayList<String> times;
    boolean open;
    ArrayList<String> tags;
    int distanceTo;
    boolean delivery;
    Image image;

    public Restaurant(String n, String a, ArrayList<String> times, ArrayList<String> tags) {
        this.name = n;
        this.address = a;
        this.tags = tags;
    }

    public Restaurant(String n, String a, String gL) {
        this.name = n;
        this.address = a;
        this.genLocation = gL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<String> getTimes() {
        return this.times;
    }

    public void setTimes(ArrayList<String> times) {
        this.times = times;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public int getDistanceTo() {
        return distanceTo;
    }

    public void setDistanceTo(int distanceTo) {
        this.distanceTo = distanceTo;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getRawName() {
        String rawName = name.toLowerCase();
        rawName.replaceAll("\\s+","");
        return rawName;
    }
}
