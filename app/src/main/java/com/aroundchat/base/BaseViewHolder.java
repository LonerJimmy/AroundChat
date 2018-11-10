package com.aroundchat.base;

import android.view.View;

public abstract class BaseViewHolder {
    protected View rootView;

    protected BaseViewHolder(View rootView) {
        this.rootView = rootView;

        init();
        bindViews();
    }

    protected abstract void bindViews();

    protected void init() {
    }

}
