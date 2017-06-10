package com.zkteam.aoc.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.ImageLoader;
import com.zkteam.aoc.view.ZKTeamFrescoView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseFragment
 * Created by WangQing on 2017/6/10.
 */

public abstract class BaseFragment extends Fragment {

    protected View rootView;
    protected Context mContext = null;
    protected Unbinder unbinder;

    @LayoutRes
    protected abstract int getLayoutId();
    protected abstract void initData();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getLayoutId() != 0) {
            rootView = inflater.inflate(getLayoutId(), null);
        } else {
            rootView = super.onCreateView(inflater, container, savedInstanceState);
        }
        if (rootView != null) {
            unbinder = ButterKnife.bind(this, rootView);
            initData();
        }
        return rootView;
    }

    public View findViewById(@IdRes int id) {
        return rootView.findViewById(id);
    }

    public void loadImage(ZKTeamFrescoView frescoView, String picUrl) {
        ImageLoader.loadImage(frescoView, picUrl);
    }

    public void loadImage(SimpleDraweeView frescoView, String picUrl) {
        ImageLoader.loadImage(frescoView, picUrl);
    }


    @Override
    public void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
