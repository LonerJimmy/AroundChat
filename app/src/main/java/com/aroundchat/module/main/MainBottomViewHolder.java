package com.aroundchat.module.main;

import android.view.View;
import android.widget.ImageView;

import com.aroundchat.R;
import com.aroundchat.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainBottomViewHolder extends BaseViewHolder {

    private List<ImageView> bottomViews;
    private Listener listener;

    public MainBottomViewHolder(View rootView) {
        super(rootView);
    }

    @Override
    protected void bindViews() {
        bottomViews.add((ImageView) rootView.findViewById(R.id.iv_friends));
        bottomViews.add((ImageView) rootView.findViewById(R.id.iv_chat));
        bottomViews.add((ImageView) rootView.findViewById(R.id.iv_person));

        bottomViews.get(0).setSelected(true);

        bottomViews.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select(0);
                if (listener != null) {
                    listener.onFriendsSelect();
                }
            }
        });

        bottomViews.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onChatSelect();
                }
            }
        });

        bottomViews.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onPersonSelect();
                }
            }
        });
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

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {
        public void onFriendsSelect();

        public void onChatSelect();

        public void onPersonSelect();
    }
}
