package com.example.ericshiao.foodaround.ListAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ericshiao.foodaround.Food;
import com.example.ericshiao.foodaround.R;

import java.util.ArrayList;

/**
 * Created by Eric on 5/24/2015.
 */
public class MenuAdapter extends RecyclerView.Adapter {

    ArrayList<Food> menu;

    public MenuAdapter(ArrayList<Food> menu) {
        this.menu = menu;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

}
