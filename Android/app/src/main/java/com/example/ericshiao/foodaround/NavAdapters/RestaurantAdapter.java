package com.example.ericshiao.foodaround.NavAdapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Eric on 3/5/2015.
 */
public class RestaurantAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;

    private final String FRAGMENT_TITLE_1 = "Info";
    private final String FRAGMENT_TITLE_2 = "Menu";
    private final String FRAGMENT_TITLE_3 = "Comments";

    public RestaurantAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        fragmentList = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return FRAGMENT_TITLE_1;
            case 1:
                return FRAGMENT_TITLE_2;
            case 2:
                return FRAGMENT_TITLE_3;
            default:
                break;
        }
        return null;
    }
}

