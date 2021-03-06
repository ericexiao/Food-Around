package com.example.ericshiao.foodaround.MainNavFragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ericshiao.foodaround.Managers.MySQLiteManager;
import com.example.ericshiao.foodaround.R;
import com.example.ericshiao.foodaround.Restaurant;
import com.example.ericshiao.foodaround.RestaurantActivity;
import com.example.ericshiao.foodaround.ListAdapters.RestaurantAdapter;
import com.example.ericshiao.foodaround.NavAdapters.MainAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 5/24/2015.
 */
public class MainFragment extends Fragment {

    public static final String RESTAURANT_DETAIL_KEY = "restaurant";
    ListView list;
    RestaurantAdapter adapter;
    MySQLiteManager dbHelper;
    MainAdapter navAdapter;
    List<Fragment> fragManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        dbHelper = new MySQLiteManager(getActivity());
        list = (ListView) root.findViewById(R.id.restaurants);
        adapter = new RestaurantAdapter(getActivity(), getDirectory());
        list.setAdapter(adapter);

        goToSelectedRestaurant();

        return root;
    }

    /*
    returns an arraylist of restaurant objects for the list adapter on the main activity
     */
    public ArrayList<Restaurant> getDirectory() {
        ArrayList<Restaurant> directory = new ArrayList<Restaurant>();
        Cursor raw = dbHelper.getRestaurantDirectory(0);
        if (raw.moveToFirst()) {
            do  {
                //insert cursor data into restaurant objects
                String name = raw.getString(1);
                String address = raw.getString(2);
                String genLocation = raw.getString(3);
                String rawTimes = raw.getString(4);
                Restaurant insert = new Restaurant(name, address, genLocation);
                directory.add(insert);
            } while (raw.moveToNext());
        }
        return directory;
    }

    public void goToSelectedRestaurant() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View item, int position, long rowId) {
                Intent i = new Intent(getActivity(), RestaurantActivity.class);
                Restaurant selected = (Restaurant) list.getItemAtPosition(position);
                i.putExtra("selected", selected.getRawName());

                startActivity(i);
            }
        });
    }
}
