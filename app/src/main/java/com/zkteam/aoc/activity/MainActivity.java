package com.zkteam.aoc.activity;

import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.zkteam.aoc.R;
import com.zkteam.aoc.adapter.MainViewpagerAdapter;
import com.zkteam.aoc.fragment.MainFragment;
import com.zkteam.aoc.fragment.SecondFragment;
import com.zkteam.aoc.fragment.ThreeFragment;
import com.zkteam.aoc.fragment.anim.ZoomOutPageTransformer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/**
 * http://blog.csdn.net/guolin_blog/article/details/53122387
 */
public class MainActivity extends AppCompatActivity {

    private static final int TYPE_FRAGMENT_MAIN = 0;
    private static final int TYPE_FRAGMENT_SECOND = 1;
    private static final int TYPE_FRAGMENT_THREE = 2;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef( value = {
            TYPE_FRAGMENT_MAIN,
            TYPE_FRAGMENT_SECOND,
            TYPE_FRAGMENT_THREE})
    public @interface CurrentFragment {}

    private void switchViewPager(@CurrentFragment int currentFragment) {
        mViewPager.setCurrentItem(currentFragment, true);
    }


    private ConstraintLayout mContainer;
    private ViewPager mViewPager;
    private BottomNavigationView navigation;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContainer = (ConstraintLayout) findViewById(R.id.container);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
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
    protected void onDestroy() {
        super.onDestroy();
        mViewPager.clearOnPageChangeListeners();
    }





}
