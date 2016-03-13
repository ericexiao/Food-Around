package com.example.ericshiao.foodaround.Search;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.ListView;

import com.example.ericshiao.foodaround.ListAdapters.RestaurantAdapter;
import com.example.ericshiao.foodaround.Managers.MySQLiteManager;
import com.example.ericshiao.foodaround.R;
import com.example.ericshiao.foodaround.Restaurant;
import com.example.ericshiao.foodaround.RestaurantActivity;

import java.util.ArrayList;


public class SearchActivity extends ActionBarActivity {

    public static final String RESTAURANT_DETAIL_KEY = "restaurant";
    ListView list;
    int selectedItem;
    //ArrayList<Restaurant> directory;
    RestaurantAdapter adapter;
    MySQLiteManager dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedItem = 0;
        setTitle("Search Results");

        dbHelper = new MySQLiteManager(this);


        list = (ListView) findViewById(R.id.restaurants);
        adapter = new RestaurantAdapter(this, getDirectory());
        list.setAdapter(adapter);

        onRestaurantClick();

    }

    /*
    returns an arraylist of restaurant objects for the list adapter on the main activity
     */
    public ArrayList<Restaurant> getDirectory() {
        ArrayList<Restaurant> directory = new ArrayList<Restaurant>();
        Cursor raw = dbHelper.getRestaurantDirectory(selectedItem);
        Log.d("here", "name");
        if (raw.moveToFirst()) {
            do  {
                //insert cursor data into restaurant objects
                String name = raw.getString(1);
                String address = raw.getString(2);
                String genLocation = raw.getString(3);
                String rawTimes = raw.getString(4);
                Restaurant insert = new Restaurant(name, address, genLocation);
                //insert into arraylist
                directory.add(insert);
            } while (raw.moveToNext());
        }
        return directory;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //ActionBar actionBar = getSupportActionBar();
        final ActionMenuItemView restaurantSort = (ActionMenuItemView) findViewById(R.id.action_restaurantSort);
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(SearchActivity.this, SettingsActivity.class);
            startActivity(intent);
            //return true;
        }

        if (id == R.id.action_search) {

        }
        if (id == R.id.action_restaurantSort) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onRestaurantClick() {
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View item, int position, long rowId) {
                Intent i = new Intent(SearchActivity.this, RestaurantActivity.class);
                Restaurant selected = (Restaurant) list.getItemAtPosition(position);
                i.putExtra("selected", selected.getName());
                //Toast toast = Toast.makeText(MainActivity.this, selected.name, Toast.LENGTH_SHORT);
                //toast.show();

                startActivity(i);
            }
        });
    }
}
