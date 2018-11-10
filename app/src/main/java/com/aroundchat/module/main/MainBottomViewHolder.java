package com.aroundchat.module.main;

import android.view.View;
import android.widget.ImageView;

import com.aroundchat.R;
import com.aroundchat.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainBottomViewHolder extends BaseViewHolder {

    private List<ImageView> bottomViews;

    public MainBottomViewHolder(View rootView) {
        super(rootView);
    }

    @Override
    protected void bindViews() {
        bottomViews.add((ImageView) rootView.findViewById(R.id.iv_friends));
        bottomViews.add((ImageView) rootView.findViewById(R.id.iv_chat));
        bottomViews.add((ImageView) rootView.findViewById(R.id.iv_person));

        bottomViews.get(0).setSelected(true);
    }

    @Override
    protected void init() {
        bottomViews = new ArrayList<>();
    }

    public void select(int index) {
        for (int i = 0; i < bottomViews.size(); i++) {
            if (i == index) {
                bottomViews.get(i).setSelected(true);
            } else {
                bottomViews.get(i).setSelected(false);
            }
        }
    }
}
