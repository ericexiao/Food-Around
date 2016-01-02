package com.example.ericshiao.foodaround;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.ericshiao.foodaround.Homeless.ExpandableMenuAdapter;
import com.example.ericshiao.foodaround.Managers.MySQLiteManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Eric on 3/5/2015.
 */
public class MenuSectionFragment extends Fragment {
    List<String> courseTypes;
    Map<String, List<Food>> menuChildren = new HashMap<String, List<Food>>();
    List<String> childList;
    int sortID;
    public String restaurantName;
    MySQLiteManager dbHelper;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.fragment_section_menu, container, false);

        sortID = getArguments().getInt("sortingOption");
        restaurantName = getArguments().getString("restaurant");
        dbHelper = new MySQLiteManager(getActivity());

        courseTypes = getCourses();
        menuChildren = getMenu();
        final ExpandableListView list = (ExpandableListView) rootView.findViewById(R.id.list);
        ExpandableMenuAdapter restaurantAdapter = new ExpandableMenuAdapter(getActivity(), courseTypes, menuChildren);
        list.setAdapter(restaurantAdapter);
        list.setGroupIndicator(null);
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

    /*private Map<String, List<Food>> populateMenu(List<String> courses) {
        Map<String, List<Food>> m = new HashMap<String, List<Food>>();

        ArrayList<Food> appetizers = new ArrayList<Food>();
        ArrayList<Food> entrees = new ArrayList<Food>();
        ArrayList<Food> desserts = new ArrayList<Food>();
        ArrayList<Food> beverages = new ArrayList<Food>();

        Food food1 = new Food("Appetizer", "3.99", false, -1, true, "This is a delicious appetizer", "entree");
        Food food2 = new Food("Sandwich", "5.99", false, -1, false, "This is a sandwich", "entree");
        Food food3 = new Food("Burger", "6.99", false, -1, false, "This is a juicy burger", "entree");
        Food food4 = new Food("Speciality Burger", "8.99", false, -1, false, "This is a speciality/popular burger", "entree");
        Food food5 = new Food("Drink", "2.99", false, -1, false, "This is a drink", "entree");

        appetizers.add(food1);
        appetizers.add(food1);
        entrees.add(food2);
        entrees.add(food2);
        desserts.add(food3);
        desserts.add(food3);
        desserts.add(food3);
        beverages.add(food5);

        ArrayList<ArrayList<Food>> foods = new ArrayList<ArrayList<Food>>();
        foods.add(appetizers);
        foods.add(entrees);
        foods.add(desserts);
        foods.add(beverages);
        foods.add(beverages);
        for (int i = 0;i < courses.size() ;i++) {
            m.put(courses.get(i), foods.get(i));
        }
        return m;
    }*/
}