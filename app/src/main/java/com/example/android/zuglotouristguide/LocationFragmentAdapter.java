package com.example.android.zuglotouristguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class LocationFragmentAdapter extends FragmentPagerAdapter {
    private static final int NUM_PAGES = 4;
    private String[] pageTitles = new String[NUM_PAGES];
    private Context context;

    LocationFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        pageTitles[0] = context.getString(R.string.sights);
        pageTitles[1] = context.getString(R.string.museums);
        pageTitles[2] = context.getString(R.string.freetime);
        pageTitles[3] = context.getString(R.string.bars);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SightsFragment();
            case 1:
                return new MuseumsFragment();
            case 2:
                return new FreetimeFragment();
            case 3:
                return new BarsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }
}
