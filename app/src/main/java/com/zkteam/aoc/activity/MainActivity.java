package com.zkteam.aoc.activity;

import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.zkteam.aoc.R;
import com.zkteam.aoc.adapter.MainViewpagerAdapter;
import com.zkteam.aoc.base.BaseActivity;
import com.zkteam.aoc.fragment.MainFragment;
import com.zkteam.aoc.fragment.SecondFragment;
import com.zkteam.aoc.fragment.ThreeFragment;
import com.zkteam.aoc.fragment.anim.ZoomOutPageTransformer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * MainActivity
 * Created by WangQing on 2017/6/10.
 */

public class MainActivity extends BaseActivity {

    // 以下是 注解的 fragment 的标识
    public static final int TYPE_FRAGMENT_MAIN = 0;
    public static final int TYPE_FRAGMENT_SECOND = 1;
    public static final int TYPE_FRAGMENT_THREE = 2;


    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = {
            TYPE_FRAGMENT_MAIN,
            TYPE_FRAGMENT_SECOND,
            TYPE_FRAGMENT_THREE})
    public @interface CurrentFragment {
    }


    @BindView(R.id.viewPaper)
    ViewPager mViewPager;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        List<Fragment> views = new ArrayList<>();
        views.add(new MainFragment());
        views.add(new SecondFragment());
        views.add(new ThreeFragment());

        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
//        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mViewPager.setAdapter(new MainViewpagerAdapter(getSupportFragmentManager(), views));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_main:
                    switchViewPager(TYPE_FRAGMENT_MAIN);
                    return true;
                case R.id.navigation_second:
                    switchViewPager(TYPE_FRAGMENT_SECOND);
                    return true;
                case R.id.navigation_three:
                    switchViewPager(TYPE_FRAGMENT_THREE);
                    return true;
            }
            return false;
        }
    };


    private ViewPager.OnPageChangeListener mOnPageChangeListener
            = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            switch (i) {
                case TYPE_FRAGMENT_MAIN:
                    navigation.setSelectedItemId(R.id.navigation_main);
                    break;
                case TYPE_FRAGMENT_SECOND:
                    navigation.setSelectedItemId(R.id.navigation_second);
                    break;
                case TYPE_FRAGMENT_THREE:
                    navigation.setSelectedItemId(R.id.navigation_three);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    private void switchViewPager(@CurrentFragment int currentFragment) {
        mViewPager.setCurrentItem(currentFragment, true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewPager.clearOnPageChangeListeners();
    }
}