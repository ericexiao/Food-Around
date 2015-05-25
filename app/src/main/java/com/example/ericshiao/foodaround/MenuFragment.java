package com.example.ericshiao.foodaround;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Eric on 3/5/2015.
 */
public class MenuFragment extends Fragment {
    List<String> courseTypes;
    ArrayList<Food> menu;
    List<String> childList;
    int sortID;
    public String restaurantName;
    DatabaseHelper dbHelper;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        sortID = getArguments().getInt("sortingOption");
        restaurantName = getArguments().getString("restaurant");
        dbHelper = new DatabaseHelper(getActivity());

        courseTypes = getCourses();
        menu = getMenu();
        final ListView list = (ListView) rootView.findViewById(R.id.list);
        MenuListAdapter restaurantAdapter = new MenuListAdapter(getActivity(), menu);
        list.setAdapter(restaurantAdapter);
        return rootView;
    }

    private List<String> getCourses() {
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Appetizers");
        courses.add("Entrees");
        courses.add("Desserts");
        courses.add("Beverages");
        //courses.add("" + sortID);
        return courses;
    }

    private ArrayList<Food> getMenu() {
        ArrayList<Food> a;
        a = dbHelper.queryMenu(restaurantName, sortID);
        return a;
    }
}