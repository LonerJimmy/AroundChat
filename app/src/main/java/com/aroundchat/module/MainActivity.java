package com.aroundchat.module;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.aroundchat.R;
import com.aroundchat.base.activity.BaseActivity;
import com.aroundchat.base.adapter.BasePagerAdapter;
import com.aroundchat.module.main.MainBottomViewHolder;

public class MainActivity extends BaseActivity {

    private ViewPager mainViewPager;
    private BasePagerAdapter pagerAdapter;
    private MainBottomViewHolder mainBottomViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initFragment();

        init();
    }

    private void initViews() {
//        mainTabLayout = findViewById(R.id.tl_bottom);
        mainViewPager = findViewById(R.id.vp_main);
        mainBottomViewHolder = new MainBottomViewHolder(findViewById(R.id.view_bottom));
    }

    private void init() {
        mainBottomViewHolder.setListener(new MainBottomViewHolder.Listener() {
            @Override
            public void onFriendsSelect() {
                mainViewPager.setCurrentItem(0);
            }

            @Override
            public void onChatSelect() {
                mainViewPager.setCurrentItem(1);
            }

            @Override
            public void onPersonSelect() {
                mainViewPager.setCurrentItem(2);
            }
        });
    }

    private void initFragment() {

        pagerAdapter = new BasePagerAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(pagerAdapter);
        mainViewPager.setCurrentItem(0, false);
        mainViewPager.setOffscreenPageLimit(3);
        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("position", "位置是" + position);
                mainBottomViewHolder.select(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
