package com.example.taoguo.cloudreadertest.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.taoguo.cloudreadertest.R;
import com.example.taoguo.cloudreadertest.base.BaseActivity;
import com.example.taoguo.cloudreadertest.databinding.ActivityNavDeedBackBinding;
import com.example.taoguo.cloudreadertest.utils.PerfectClickListener;
import com.example.taoguo.cloudreadertest.view.webview.WebViewActivity;

public class NavDeedBackActivity extends BaseActivity<ActivityNavDeedBackBinding> {

    private static String string_url_faq = "http://jingbin.me/2016/12/25/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98-%E4%BA%91%E9%98%85/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_deed_back);
        setTitle("问题反馈");
        showContentView();

        bindingView.tvIssues.setOnClickListener(listener);
        bindingView.tvJianshu.setOnClickListener(listener);
        bindingView.tvQq.setOnClickListener(listener);
        bindingView.tvEmail.setOnClickListener(listener);
        bindingView.tvFaq.setOnClickListener(listener);
    }

    private PerfectClickListener listener = new PerfectClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.tv_issues:
                    WebViewActivity.loadUrl(v.getContext(),"https://github.com/youlookwhat/CloudReader/issues","Issues");
                    break;
                case R.id.tv_qq:
                    String url = "mqqwpa://im/chat?chat_type=wpa&uin=770413277";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    break;
                case R.id.tv_email:
                    Intent data = new Intent(Intent.ACTION_SENDTO);
                    data.setData(Uri.parse("mailto:jingbin127@163.com"));
                    startActivity(data);
                    break;
                case R.id.tv_jianshu:
                    WebViewActivity.loadUrl(v.getContext(), "http://www.jianshu.com/users/e43c6e979831/latest_articles","加载中...");
                    break;
                case R.id.tv_faq:
                    WebViewActivity.loadUrl(v.getContext(),string_url_faq,"常见问题归纳");
                    break;
            }
        }
    };

    public static void start(Context mContext) {
        Intent intent = new Intent(mContext, NavDeedBackActivity.class);
        mContext.startActivity(intent);
    }
}
