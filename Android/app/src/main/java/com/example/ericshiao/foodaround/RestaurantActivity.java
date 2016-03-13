package com.example.ericshiao.foodaround;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ericshiao.foodaround.NavAdapters.RestaurantAdapter;
import com.example.ericshiao.foodaround.RestaurantFragments.InfoSectionFragment;
import com.example.ericshiao.foodaround.RestaurantFragments.MenuSectionFragment;
import com.example.ericshiao.foodaround.Search.SettingsActivity;

import java.util.ArrayList;

import java.util.List;

/**
 * Created by Eric on 12/28/2014.
 */

/*
Purpose of class is to initialize the RestuarantActivity screen. The produces the information of the
restuarant (such as location, opening and closing times, etc. ) as well as the menu and menu
information (name, price, description, etc).
The activity uses a navPager and an expandable list for navigation.
 */
public class RestaurantActivity extends ActionBarActivity {

    List<Fragment> fragManager;
    ViewPager rNavPager;
    RestaurantAdapter restaurantAdapter;
    int selectedItem;
    String restaurantName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        Intent info = getIntent();
        restaurantName = info.getStringExtra("selected");
        selectedItem = info.getIntExtra("sortingOption", 0);
        setTitle(restaurantName);
        actionBar.setDisplayHomeAsUpEnabled(true);

        MenuSectionFragment menuFragment = new MenuSectionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("sortingOption", selectedItem);
        bundle.putString("restaurant", restaurantName);
        menuFragment.setArguments(bundle);
        fragManager = new ArrayList<>();
        fragManager.add(new InfoSectionFragment());
        fragManager.add(menuFragment);
        //fragManager.add(new InputSectionFragment());


        rNavPager = (ViewPager) findViewById(R.id.rPager);
        restaurantAdapter = new RestaurantAdapter(getSupportFragmentManager(), fragManager);
        rNavPager.setAdapter(restaurantAdapter);
        rNavPager.setCurrentItem(1);


    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restaurant, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        final ActionMenuItemView menuSort = (ActionMenuItemView) findViewById(R.id.action_menu_sort);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(RestaurantActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_menu_sort) {
            AlertDialog.Builder menuSortBuilder = new AlertDialog.Builder(this);
            CharSequence[] sortOptions = {"Alphabetical", "Course Type", "Eaten", "Price", "Speciality"};
            menuSortBuilder
                    .setTitle("Sort Menu By...")
                    .setCancelable(true)
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            final int selected = selectedItem;
            menuSortBuilder.setSingleChoiceItems(sortOptions, selected, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            menuSort.setIcon(getResources().getDrawable(R.drawable.abc_sort));
                            selectedItem = which;
                            updateSorting(selectedItem);
                            dialog.dismiss();
                            break;
                        case 1:
                            menuSort.setIcon(getResources().getDrawable(R.drawable.course_type_sort));
                            selectedItem = which;
                            updateSorting(selectedItem);
                            dialog.dismiss();
                            break;
                        case 2:
                            menuSort.setIcon(getResources().getDrawable(R.drawable.eaten_sort));
                            selectedItem = which;
                            updateSorting(selectedItem);
                            dialog.dismiss();
                            break;
                        case 3:
                            menuSort.setIcon(getResources().getDrawable(R.drawable.price_sort));
                            selectedItem = which;
                            updateSorting(selectedItem);
                            dialog.dismiss();
                            break;
                        case 4:
                            menuSort.setIcon(getResources().getDrawable(R.drawable.speciality_sort));
                            selectedItem = which;
                            updateSorting(selectedItem);
                            dialog.dismiss();
                            break;
                        default:
                            break;
                    }
                }
            });
            AlertDialog menuSortMenu = menuSortBuilder.create();
            menuSortMenu.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateSorting(int sortingOption) {
        Intent refresh = new Intent(this, RestaurantActivity.class);
        refresh.putExtra("sortingOption", sortingOption);
        finish();
        startActivity(refresh);
      }
}
