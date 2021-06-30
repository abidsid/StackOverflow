package com.example.stackoverflow.ui.adapters;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.stackoverflow.utils.Utils;

public class DataBindingAdapter {

    @BindingAdapter("imagePath")
    public static void loadImage(ImageView imageView, String imagePath) {
        Utils.loadImage(imageView, imagePath);
    }

}
