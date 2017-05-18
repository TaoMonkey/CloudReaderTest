package com.example.taoguo.cloudreadertest.utils;

import android.widget.Toast;

import com.example.taoguo.cloudreadertest.app.CloudReaderApplication;

/**
 * Created by taoguo on 2017/5/18.
 */

public class ToastUtil {

    private static Toast mToast;

    public static void showToast(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(CloudReaderApplication.getInstance(), text, Toast.LENGTH_SHORT);
        }
        mToast.setText(text);
        mToast.show();
    }
}
