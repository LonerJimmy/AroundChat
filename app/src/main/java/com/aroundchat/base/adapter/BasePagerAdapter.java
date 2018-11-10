package com.aroundchat.base.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aroundchat.base.fragment.FragmentFactory;

import java.util.List;

public class BasePagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> list;

    public BasePagerAdapter(FragmentManager fm) {
        super(fm);
        list = FragmentFactory.createForMain();
    }

    @Override
    public int getCount() {
        return list .size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

}
