package com.example.taoguo.cloudreadertest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.example.taoguo.cloudreadertest.app.ConstantsImageUrl;
import com.example.taoguo.cloudreadertest.databinding.ActivityMainBinding;
import com.example.taoguo.cloudreadertest.databinding.NavHeaderMainBinding;
import com.example.taoguo.cloudreadertest.ui.NavHomePageActivity;
import com.example.taoguo.cloudreadertest.ui.menu.NavAboutActivity;
import com.example.taoguo.cloudreadertest.ui.menu.NavDeedBackActivity;
import com.example.taoguo.cloudreadertest.ui.menu.NavDownloadActivity;
import com.example.taoguo.cloudreadertest.utils.ImgLoadUtil;
import com.example.taoguo.cloudreadertest.utils.PerfectClickListener;
import com.example.taoguo.cloudreadertest.view.webview.WebViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private ActivityMainBinding mBinding;
    private Toolbar toolbar;
    private NavigationView navView;
    private DrawerLayout drawerLayout;
    private FrameLayout llTitleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initId();
        initContentFragment();
        initDrawerLayout();
    }

    //初始化控件id
    private void initId() {
        drawerLayout = mBinding.drawerLayout;//抽屉布局
        toolbar = mBinding.include.toolbar;  //状态栏
        navView = mBinding.navView;

        llTitleMenu = mBinding.include.llTitleMenu;  //状态栏中打开侧滑菜单的按钮
    }
    private void initContentFragment() {

        //将application theme设置为noActionba
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    NavHeaderMainBinding bind;

    private void initDrawerLayout() {
        llTitleMenu.setOnClickListener(this);
        navView.inflateHeaderView(R.layout.nav_header_main);
        View headerView = navView.getHeaderView(0);
        bind = DataBindingUtil.bind(headerView);
        //这个做啥子的？
        bind.setListener(this);
        //使用glide加载用户头像
        ImgLoadUtil.displayCircle(bind.ivAvatar, ConstantsImageUrl.IC_AVATAR);

        bind.llNavExit.setOnClickListener(this);
        bind.ivAvatar.setOnClickListener(this);

        bind.llNavHomepage.setOnClickListener(listener);
        bind.llNavScanDownload.setOnClickListener(listener);
        bind.llNavDeedback.setOnClickListener(listener);
        bind.llNavAbout.setOnClickListener(listener);
        bind.llNavLogin.setOnClickListener(listener);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_title_menu:// 开启菜单
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.iv_avatar: // 头像进入GitHub
                WebViewActivity.loadUrl(view.getContext(),"https://github.com/youlookwhat/CloudReader","CloudReader");
                break;
            case R.id.ll_nav_exit:// 退出应用
                finish();
                break;
        }
    }

    private PerfectClickListener listener = new PerfectClickListener() {
        @Override
        public void onNoDoubleClick(final View v) {
            mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            mBinding.drawerLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    switch (v.getId()) {
                        case R.id.ll_nav_homepage://主页
                            NavHomePageActivity.startHome(MainActivity.this);
                            break;
                        case R.id.ll_nav_scan_download://扫码下载
                            NavDownloadActivity.start(MainActivity.this);
                            break;
                        case R.id.ll_nav_deedback:// 问题反馈
                            NavDeedBackActivity.start(MainActivity.this);
                            break;
                        case R.id.ll_nav_about:// 关于云阅
                            NavAboutActivity.start(MainActivity.this);
                            break;
                        case R.id.ll_nav_login:// 登录GitHub账号
                            WebViewActivity.loadUrl(v.getContext(), "https://github.com/login", "登录GitHub账号");
                            break;
                    }
                }
            }, 260);
        }
    };
}
