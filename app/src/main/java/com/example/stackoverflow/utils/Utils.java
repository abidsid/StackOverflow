package com.example.stackoverflow.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.Date;

public class Utils {

    public static void loadImage(ImageView imageView, String imagePath) {
        Glide
                .with(imageView.getContext())
                .load(imagePath)
                .transition(DrawableTransitionOptions.withCrossFade())
                .circleCrop()
                .into(imageView);
    }

    public static String convertLongToDate(long creationDate) {
        Date date = new Date(creationDate * 1000);
        return date.toString();
    }

}
