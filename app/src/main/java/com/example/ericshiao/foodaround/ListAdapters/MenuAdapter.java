package com.example.ericshiao.foodaround.ListAdapters;

import android.content.Context;
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
public class MenuAdapter extends ArrayAdapter<Food> {

    public MenuAdapter(Context context, ArrayList<Food> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_restaurant, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);

        Food f= getItem(position);
        name.setText(f.getName());

        return convertView;
    }

    public void setImage(ImageView i) {

    }
}
