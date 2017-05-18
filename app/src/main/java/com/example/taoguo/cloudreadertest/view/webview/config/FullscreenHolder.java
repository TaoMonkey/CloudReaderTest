package com.example.taoguo.cloudreadertest.view.webview.config;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by taoguo on 2017/5/18.
 */

public class FullscreenHolder extends FrameLayout {

    public FullscreenHolder(Context ctx) {
        super(ctx);
        setBackgroundColor(ctx.getResources().getColor(android.R.color.black));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
