package com.example.taoguo.cloudreadertest.view.webview.config;

import android.view.View;

/**
 * Created by taoguo on 2017/5/17.
 */

public interface IWebPageView {

    // 隐藏进度条
    void hindProgressBar();

    // 显示webview
    void showWebView();

    // 隐藏webview
    void hindWebView();

    //  进度条先加载到90%,然后再加载到100%
    void startProgress();


    /**
     * 进度条变化时调用
     */
    void progressChanged(int newProgress);

    /**
     * 添加js监听
     */
    void addImageClickListener();

    /**
     * 播放网络视频全屏调用
     */
    void fullViewAddView(View view);

    void showVideoFullView();

    void hindVideoFullView();


}