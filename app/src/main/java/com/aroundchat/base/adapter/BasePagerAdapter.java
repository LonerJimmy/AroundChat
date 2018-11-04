package com.aroundchat.base.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aroundchat.base.fragment.FragmentFactory;

public class BasePagerAdapter extends FragmentStatePagerAdapter {

    public BasePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return FragmentFactory.createForMain().size();
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.createForMain().get(position);
    }

}
