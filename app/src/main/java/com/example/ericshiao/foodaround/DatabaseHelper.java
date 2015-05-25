package com.example.ericshiao.foodaround;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by Eric on 3/8/2015.
 */
public class DatabaseHelper extends SQLiteAssetHelper {
    private static final String DB_NAME = "foodAroundGrounds.db";
    private static final int DATABASE_VERSION = 1;

    private final String KEY_ID = "_id";
    private final String KEY_NAME = "name";
    private final String KEY_ADDRESS = "address";
    private final String KEY_GEN_LOCATION = "gen_location";
    private final String KEY_TIMES = "times";
    private final String KEY_COURSES = "courses";
    private final String KEY_COURSE_TYPE = "course_type";
    private final String KEY_RATING = "rating";
    private final String KEY_EATEN = "eaten";
    private final String KEY_DESCRIPTION = "description";
    private final String KEY_SPECIALITY = "speciality";
    private final String KEY_PRICE = "price";


    private final String TABLE_RESTAURANTS = "restaurants";

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    protected Cursor getRestaurantDirectory(int sortingOption) {
        String sortBy;
        //Log.i("Here", "Attempting to get Directory");
        switch (sortingOption) {
            case 0:
                sortBy = KEY_NAME;
            case 1:
                sortBy = KEY_ADDRESS;
            case 2:
                sortBy = KEY_GEN_LOCATION;
            default:
                sortBy = KEY_NAME;
        }
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder q = new SQLiteQueryBuilder();
        q.setTables(TABLE_RESTAURANTS);
        Cursor rawDirectory = q.query(db,
                new String[]{KEY_ID, KEY_NAME, KEY_ADDRESS, KEY_GEN_LOCATION, KEY_TIMES}, //table columns
                null, //WHERE statement
                null, //? fillers
                null, //group by
                null, //having
                sortBy, //order By
                null); //limit
        if (rawDirectory != null) {
            rawDirectory.moveToFirst();
        }
        return rawDirectory;
    }

    protected Cursor getRestaurantSearch(String name, String location, String priceAverageBottom, String priceAverageTop) {
        Cursor results;
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder q = new SQLiteQueryBuilder();
        q.setTables(TABLE_RESTAURANTS);
        results = q.query(db, new String[]{KEY_ID, KEY_NAME, KEY_COURSE_TYPE, KEY_SPECIALITY, KEY_PRICE, KEY_EATEN, KEY_RATING, KEY_DESCRIPTION},
                null, //where
                null, //? fillers
                null, //group by
                null, //having
                null, //sort by
                null); //limit);
        return results;
    }

    //consider doing multiple queries for different course types? allows to sort by different things more easily
    protected ArrayList<Food> getMenu(String restaurant, int sortingOption) {
        SQLiteDatabase db = getReadableDatabase();
        String restaurantDetails = restaurant + "Details";
        restaurantDetails.replaceAll("\\s+","");
        String userDetails = restaurant + "User";

        ArrayList<Food> ret = new ArrayList<Food>();
        String sortBy = "";

        switch (sortingOption) {
            case 0:
                sortBy = KEY_NAME;
            case 1:
                sortBy = KEY_PRICE;
            case 2:
                sortBy = KEY_EATEN;
            case 3:
                sortBy = KEY_PRICE;
            case 4:
                sortBy = KEY_SPECIALITY;
            default:
                sortBy = KEY_NAME;
        }

        String query = "SELECT * FROM " + restaurantDetails + " NATURAL JOIN " + userDetails + " ORDER BY " + sortBy;
        Cursor rawMenuDetails = db.rawQuery(query, new String[] {});

        return ret;
    }

    protected ArrayList<Food> convertRawMenu(Cursor rawMenu) {
        ArrayList<Food> menu = new ArrayList<>();
        if (rawMenu.moveToFirst()) {
            do  {
                //insert cursor data into restaurant objects
                String name = rawMenu.getString(1);
                String courseType = rawMenu.getString(2);
                int speciality = rawMenu.getInt(3);
                String price = rawMenu.getString(4);
                String description = rawMenu.getString(5);
                int eaten = rawMenu.getInt(6);
                int rating = rawMenu.getInt(7);
                Food insert = new Food(name, courseType, speciality, rating, eaten, price, description);
                //insert into arraylist
                menu.add(insert);
            } while (rawMenu.moveToNext());
        }
        return menu;
    }
}

