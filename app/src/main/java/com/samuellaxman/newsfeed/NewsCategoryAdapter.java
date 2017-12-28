package com.samuellaxman.newsfeed;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by USER on 12/27/2017.
 */

public class NewsCategoryAdapter extends FragmentPagerAdapter {

    //mContext is the context of the app
//    private Context mContext;


    public NewsCategoryAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TopStoriesFragment();
        } else if (position == 1) {
            return new TechnologyFragment();
        } else if (position == 2) {
            return new PoliticsFragment();
        } else if (position == 3) {
            return new BusinessFragment();
        } else {
            return new SportsFragment();
        }
    }
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Top Stories";
        } else if (position == 1) {
            return "Technology";
        } else if (position == 2) {
            return "Politics";
        } else if (position == 3) {
            return "Business";
        } else  if (position == 4){
            return "Sports";
        }else {
            return null;
        }

    }
}
