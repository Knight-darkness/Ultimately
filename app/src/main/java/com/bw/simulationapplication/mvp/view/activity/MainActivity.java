package com.bw.simulationapplication.mvp.view.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.bw.simulationapplication.R;
import com.bw.simulationapplication.base.BaseActivity;
import com.bw.simulationapplication.mvp.view.fragment.HomeFragment;
import com.bw.simulationapplication.mvp.view.fragment.OtherFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ViewPager pager;
    private TabLayout tab;
    private ArrayList<String> strings;
    private ArrayList<Fragment> fragments;
    private HomeFragment homeFragment;
    private OtherFragment otherFragment;

    //本页面只提供activity加fragment的效果
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //查询资源id
        pager = (ViewPager) findViewById(R.id.viewpager);
        tab = (TabLayout) findViewById(R.id.tablayout);
        strings = new ArrayList<>();
        fragments = new ArrayList<>();
        homeFragment = new HomeFragment();
        otherFragment = new OtherFragment();
        strings.add("首页");
        strings.add("我的");
        fragments.add(homeFragment);
        fragments.add(otherFragment);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });
        tab.setupWithViewPager(pager);
    }

    @Override
    protected int layoutID() {
        return R.layout.activity_main;
    }
}
