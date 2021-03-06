package com.example.ericshiao.foodaround.ListAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ericshiao.foodaround.R;
import com.example.ericshiao.foodaround.Restaurant;

import java.util.ArrayList;

/**
 * Created by Eric on 1/2/2015.
 */
public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    public RestaurantAdapter(Context context, ArrayList<Restaurant> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Restaurant r = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_restaurant, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView address = (TextView) convertView.findViewById(R.id.addressDetail);
        TextView genLocation = (TextView) convertView.findViewById(R.id.genLocation);
        ImageView open = (ImageView) convertView.findViewById(R.id.open);
        ImageView picture = (ImageView) convertView.findViewById(R.id.picture);

        name.setText(r.getName());
        address.setText(r.getAddress());
        //genLocation.setText(" - " + r.getGeneralLocation());

        return convertView;
    }

    public void setImage(ImageView i) {

    }
}
