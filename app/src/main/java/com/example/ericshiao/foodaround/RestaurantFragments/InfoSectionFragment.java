package com.example.ericshiao.foodaround.RestaurantFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ericshiao.foodaround.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Eric on 3/5/2015.
 */

public class InfoSectionFragment extends Fragment {
    private GoogleMap map;
    private SupportMapFragment mapFrag;
    public static View rootView;
    private String info = "M 9:00 AM - 10:00 PM";
    public String restaurantName;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        restaurantName = getActivity().getIntent().getStringExtra("selected");

        if (rootView != null) {
            ViewGroup parent = (ViewGroup)  rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }
        try {
            rootView = inflater.inflate(R.layout.fragment_section_info, container, false);
        } catch (InflateException e) {

        }
        mapFrag = new SupportMapFragment();
        mapFrag = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        //ft = getChildFragmentManager().beginTransaction();
        //ft.add(R.id.map, mapFrag).commit();
        mapFrag.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                final LatLng restaurantLocation = new LatLng(38.03, -78.51);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurantLocation, 16));
                map.addMarker(new MarkerOptions().position(restaurantLocation).visible(true));
            }
        });
        //Button resetMap = (Button) rootView.findViewById(R.id.resetMap);
        TextView openTimes = (TextView) rootView.findViewById(R.id.openTimes);
        openTimes.setText(info);

        return rootView;
    }
}


