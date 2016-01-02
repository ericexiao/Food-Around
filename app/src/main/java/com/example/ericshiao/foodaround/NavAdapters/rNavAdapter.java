package com.example.ericshiao.foodaround.NavAdapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Eric on 3/5/2015.
 */
public class rNavAdapter extends FragmentPagerAdapter {
    List<Fragment> fragList;

    public rNavAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        fragList = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragList.get(i);
    }

    @Override
    public int getCount() {
        return fragList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Info";
            case 1:
                return "Menu";
            case 2:
               return "Comments";
            default:
                break;
        }
        return null;
    }
}

