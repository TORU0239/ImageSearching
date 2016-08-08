package io.toru.imagesearching.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by toru on 2016. 8. 8..
 */
public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = MainViewPagerAdapter.class.getSimpleName();

    private List<Fragment> fragmentList;
    public MainViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "List";
            case 1:
                return "Widgets";
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        Log.w(TAG, "getItem: position :: " + position);
        return fragmentList.get(position);
    }
}
