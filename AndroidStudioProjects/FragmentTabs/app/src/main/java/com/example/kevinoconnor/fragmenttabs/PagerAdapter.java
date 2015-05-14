package com.example.kevinoconnor.fragmenttabs;

/**
 * Created by kevinoconnor on 5/12/15.
 */
public class PagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    public PagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        android.support.v4.app.Fragment frag = null;
        switch(position){
            case 0:
                frag = new Scion();
                break;
            case 1:
                frag = new BMW();
                break;
            case 2:
                frag = new Tesla();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String pos = "";
        switch(position){
            case 0:
                pos = "SCION";
                break;
            case 1:
                pos = "BMW";
                break;
            case 2:
                pos = "TESLA";
                break;
        }
        return pos;
    }
}
