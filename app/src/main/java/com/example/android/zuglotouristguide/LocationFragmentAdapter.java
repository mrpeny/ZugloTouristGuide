package com.example.android.zuglotouristguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class LocationFragmentAdapter extends FragmentPagerAdapter {
    private static final int NUM_PAGES = 4;
    private String[] pageTitles = new String[4];
    private Context context;

    public LocationFragmentAdapter(FragmentManager fm, Context context) {
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

    public View getTabView(int position) {
        View tab = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) tab.findViewById(R.id.tab_title);
        tv.setText(pageTitles[position]);
        return tab;
    }
}
