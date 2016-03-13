package com.example.ericshiao.foodaround.Managers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.example.ericshiao.foodaround.Food;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by Eric on 3/8/2015.
 */
public class MySQLiteManager extends SQLiteAssetHelper {
    private static final String DB_NAME = "foodAroundGrounds.db";
    private static final int DATABASE_VERSION = 1;

    //Table columns
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
    public MySQLiteManager(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    /*
     * Returns the list of all of the restaurants in the SQL database
     */
    public Cursor getRestaurantDirectory(int sortingOption) {
        String sortBy; //Variable for the "SORTBY" function in SQL query
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
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(TABLE_RESTAURANTS);
        Cursor rawDirectory = queryBuilder.query(db,
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

    /*
     * Search the database to get a return query
     *
     * TODO: Do search
     */
    public Cursor getRestaurantSearch(String name, String location, String priceAverageBottom, String priceAverageTop) {
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
    public ArrayList<Food> getMenu(String restaurant, int sortingOption) {
        SQLiteDatabase db = getReadableDatabase();
        String restaurantDetails = restaurant + "Details";
        restaurantDetails.replaceAll("\\s+","");
        String userDetails = restaurant + "User";

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
        return convertRawMenu(rawMenuDetails);
    }

    /*
     * Helper method for converting Cursors from the SQLite db into an ArrayList for the Adapters
     */
    private ArrayList<Food> convertRawMenu(Cursor rawMenu) {
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

