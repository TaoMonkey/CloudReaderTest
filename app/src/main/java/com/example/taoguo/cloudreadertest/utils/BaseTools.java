package com.example.taoguo.cloudreadertest.utils;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;

import com.example.taoguo.cloudreadertest.app.CloudReaderApplication;

/**
 * Created by taoguo on 2017/5/18.
 */

public class BaseTools {

    private static final String TAG = "BaseTools";

    /**
     * 实现文本复制功能
     *
     * @param content 复制的文本
     */
    public static void copy(String content) {
        // 得到剪贴板管理器
        ClipboardManager cmb = (ClipboardManager) CloudReaderApplication.getInstance().getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setText(content.trim());
    }

    /**
     * 使用浏览器打开链接
     */
    public static void openLink(Context context, String content) {
        Uri issuesUrl = Uri.parse(content);
        Intent intent = new Intent(Intent.ACTION_VIEW, issuesUrl);
        context.startActivity(intent);
    }

    /**
     * 获取当前应用的版本号
     */
    public static String getVersionName() {
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = CloudReaderApplication.getInstance().getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = null;
            packInfo = packageManager.getPackageInfo(CloudReaderApplication.getInstance().getPackageName(), 0);
            Log.e(TAG, "getVersionName: " + packInfo.versionName);
            return packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "1.0";
        }catch (NullPointerException e) {
            e.printStackTrace();
        }finally {
            return "1.0";
        }
    }
}
