package com.example.kotlindemo;

import android.Manifest;
import android.animation.Animator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.kotlindemo.activity.BaseActivity;
import com.example.kotlindemo.adapter.ViewPagerAdapter;
import com.example.kotlindemo.fragment.ContentFragment;
import com.example.kotlindemo.fragment.HomeFragment;
import com.example.kotlindemo.fragment.UserFragment;
import com.example.kotlindemo.permission.PermissionUtils;
import com.google.android.material.tabs.TabLayout;
import com.willowtreeapps.spruce.Spruce;
import com.willowtreeapps.spruce.animation.DefaultAnimations;
import com.willowtreeapps.spruce.sort.DefaultSort;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager2;
    private ViewPagerAdapter viewPagerAdapter;//适配器
    private List<String> titles = new ArrayList<>();//标题文字
    private List<Fragment> showFragments = new ArrayList<>();//fragment 容器
    private HomeFragment homeFragment = new HomeFragment();
    private ContentFragment contentFragment = new ContentFragment();
    private UserFragment userFragment = new UserFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getTitles();
        getFragmentList();
        setViewPagerFragmentAdapter();
        PermissionUtils permissionUtils = new PermissionUtils(this);
        permissionUtils.requestPermission(this, Manifest.permission.SEND_SMS, new PermissionUtils.PermissionRequestListener() {
            @Override
            public void onFirstRequestPermission() {
            }

            @Override
            public void onPermissionPreviouslyDenied() {
            }

            @Override
            public void onPermissionPreviouslyDeniedWithNeverAskAgain() {
            }

            @Override
            public void onPermissionGranted() {
            }
        });
    }

    /**
     * mock 标题栏数据
     */
    public void getTitles() {
        titles.add("主页");
        titles.add("内容");
        titles.add("个人");
    }

    /**
     * mock fragment 数据集
     */
    public void getFragmentList() {
        showFragments.add(homeFragment);
        showFragments.add(contentFragment);
        showFragments.add(userFragment);
    }

    /**
     * 设置 viewpager的适配器
     */
    public void setViewPagerFragmentAdapter() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.setTitles(titles);
        viewPagerAdapter.setFragment(showFragments);
        viewPager2 = findViewById(R.id.vp_show);
        viewPager2.setAdapter(viewPagerAdapter);
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager2);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_local_fire_department_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_people_24);
    }

    /**
     * 切换的时候更换图标
     */
    public void onSelectTab() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}