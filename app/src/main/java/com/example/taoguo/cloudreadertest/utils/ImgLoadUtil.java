package com.example.taoguo.cloudreadertest.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.taoguo.cloudreadertest.R;

/**
 * Created by taoguo on 2017/5/16.
 */

public class ImgLoadUtil {


    /**
     * 加载圆角图,暂时用到显示头像
     */
    public static void displayCircle(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .crossFade(500)
                .error(R.drawable.ic_avatar_default)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }

}
