package com.aroundchat.module;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.aroundchat.R;
import com.aroundchat.base.activity.BaseActivity;
import com.aroundchat.base.adapter.BasePagerAdapter;

public class MainActivity extends BaseActivity {

    private RadioGroup mainRadioGroup;
    private ViewPager mainViewPager;
    private BasePagerAdapter pagerAdapter;
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initFragment();
    }

    private void initViews() {
//        mainTabLayout = findViewById(R.id.tl_bottom);
        mainViewPager = findViewById(R.id.vp_main);
        mainRadioGroup = findViewById(R.id.rg_bottom);
        titleTextView = findViewById(R.id.tv_title);
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
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
