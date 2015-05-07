package com.example.ericshiao.foodaround;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Eric on 3/5/2015.
 */
public class LocationFragment extends Fragment {
    List<String> courseTypes;
    Map<String, List<Food>> menuChildren = new HashMap<String, List<Food>>();
    List<String> childList;
    int sortID;
    public String restaurantName;
    DatabaseHelper dbHelper;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.fragment_section_menu, container, false);

        sortID = getArguments().getInt("sortingOption");
        restaurantName = getArguments().getString("restaurant");
        dbHelper = new DatabaseHelper(getActivity());
        courseTypes = getCourses();
        final ExpandableListView list = (ExpandableListView) rootView.findViewById(R.id.list);
        ExpandableMenuAdapter restaurantAdapter = new ExpandableMenuAdapter(getActivity(), courseTypes, menuChildren);
        list.setAdapter(restaurantAdapter);
        list.setGroupIndicator(null);

        /*list.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousItem = -1;
            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousItem) {
                    list.collapseGroup(previousItem);
                    previousItem = groupPosition;
                }
            }
        });*/
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

    private Map<String, List<Food>> getMenu() {
        Map<String, List<Food>> m = new HashMap<String, List<Food>>();
        dbHelper.getMenu(restaurantName, sortID);
        return m;
    }
}