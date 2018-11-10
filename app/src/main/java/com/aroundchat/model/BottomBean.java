package com.aroundchat.model;

import android.widget.ImageView;

import java.io.Serializable;

public class BottomBean implements Serializable {

    private boolean check;
    private ImageView imageView;

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public boolean isCheck() {
        return check;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
