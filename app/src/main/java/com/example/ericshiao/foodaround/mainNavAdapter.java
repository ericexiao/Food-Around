package com.example.ericshiao.foodaround;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Eric on 3/5/2015.
 */
public class mainNavAdapter extends FragmentPagerAdapter {
    List<Fragment> fragList;

    public mainNavAdapter(FragmentManager fm, List<Fragment> fragments) {
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
                return "The Corner";
            case 1:
                return "Downtown";
            case 2:
                return "Barracks";
            case 3:
                return "JPA";
            case 4:
                return "Other";
            default:
                break;
        }
        return null;
    }
}

