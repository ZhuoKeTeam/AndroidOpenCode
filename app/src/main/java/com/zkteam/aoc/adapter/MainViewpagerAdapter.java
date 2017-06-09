package com.zkteam.aoc.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 参考：http://www.jianshu.com/p/e5abbda4a71c
 * Created by WangQing on 2017/6/9.
 */
public class MainViewpagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mViewList;

    public MainViewpagerAdapter(FragmentManager fm, List<Fragment> mViewList) {
        super(fm);
        this.mViewList = mViewList;
    }

    @Override
    public int getCount() {//必须实现
        return mViewList.size();
    }

    @Override
    public Fragment getItem(int i) {
        return mViewList.get(i);
    }

//    @Override
//    public boolean isViewFromObject(View view, Object object) {//必须实现
//        return view == object;
//    }
//
//    @Override
//    public Fragment getItem(int i) {
//        return mViewList.get(i);
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {//必须实现，实例化
//        container.addView(mViewList.get(position).getView());
//        return mViewList.get(position);
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {//必须实现，销毁
//        container.removeView(mViewList.get(position).getView());
//    }
}
