package com.example.taoguo.cloudreadertest.utils;

import android.view.View;

import java.util.Calendar;

/**
 * Created by taoguo on 2017/5/16.
 * 避免在1秒之内重复点击
 */

public abstract class PerfectClickListener implements View.OnClickListener{

    public static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;
    private int id = -1;

    @Override
    public void onClick(View view) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        int mId = view.getId();
        if (id != mId) {
            id = mId;
            lastClickTime = currentTime;
            onNoDoubleClick(view);
            return;
        }
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNoDoubleClick(view);
        }
    }

    public abstract void  onNoDoubleClick(View v);
}
