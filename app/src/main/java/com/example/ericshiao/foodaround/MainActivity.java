package com.example.ericshiao.foodaround;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ListView;

import com.example.ericshiao.foodaround.MainNavFragments.MainFragment;
import com.example.ericshiao.foodaround.Search.SearchActivity;
import com.example.ericshiao.foodaround.Search.SettingsActivity;


public class MainActivity extends ActionBarActivity {

    public static final String RESTAURANT_DETAIL_KEY = "restaurant";
    FragmentManager fm;
    MainFragment mainFragment;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Food Around Grounds");

        fm = getSupportFragmentManager();
        mainFragment = new MainFragment();
        fm.beginTransaction().replace(android.R.id.content, mainFragment).commit();
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
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            //return true;
        }

        if (id == R.id.action_search) {
            Intent intent = new Intent (MainActivity.this, SearchActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_restaurantSort) {
            sortRestaurant();
        }

        return super.onOptionsItemSelected(item);
    }

    public void sortRestaurant() {
        /*AlertDialog.Builder restaurantSortBuilder = new AlertDialog.Builder(this);
        CharSequence[] sortOptions = {"Alphabetical", "Average Entree Price", "Distance", "Open"};
        restaurantSortBuilder
                .setTitle("Sort Restaurants By...")
                .setCancelable(true)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        final int selected = selectedItem;
        restaurantSortBuilder.setSingleChoiceItems(sortOptions, selected, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        restaurantSort.setIcon(getResources().getDrawable(R.drawable.abc_sort));
                        selectedItem = which;
                        dialog.dismiss();
                        break;
                    case 1:
                        restaurantSort.setIcon(getResources().getDrawable(R.drawable.price_sort));
                        selectedItem = which;
                        dialog.dismiss();
                        break;
                    case 2:
                        restaurantSort.setIcon(getResources().getDrawable(R.drawable.distance));
                        selectedItem = which;
                        dialog.dismiss();
                        break;
                    case 3:
                        restaurantSort.setIcon(getResources().getDrawable(R.drawable.speciality_sort));
                        selectedItem = which;
                        dialog.dismiss();
                        break;
                    default:
                        break;
                }
            }
        });
        AlertDialog restaurantSortMenu = restaurantSortBuilder.create();
        restaurantSortMenu.show();
        adapter = new RestaurantMainAdapter(this, getDirectory());*/
    }
}
