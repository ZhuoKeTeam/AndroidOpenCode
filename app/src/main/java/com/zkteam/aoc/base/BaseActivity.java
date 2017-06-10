package com.zkteam.aoc.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.ImageLoader;
import com.zkteam.aoc.view.ZKTeamFrescoView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseActivity
 * Created by WangQing on 2017/6/10.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected View rootView;
    protected Context mContext = null;
    protected Unbinder unbinder;

    protected abstract int getLayout();
    protected abstract void initData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mContext = this;
        unbinder = ButterKnife.bind(this);
        initData();
    }

    public void loadImage(ZKTeamFrescoView frescoView, String picUrl) {
        ImageLoader.loadImage(frescoView, picUrl);
    }

    public void loadImage(SimpleDraweeView frescoView, String picUrl) {
        ImageLoader.loadImage(frescoView, picUrl);
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

}
