package com.aroundchat.base.fragment;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentFactory {

    /**
     * main
     *
     * @return
     */
    public static List<Fragment> createForMain() {
        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new BaseFragment());
        fragments.add(new BaseFragment());
        fragments.add(new BaseFragment());

        return fragments;
    }
}
