package com.zkteam.aoc;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zkteam.aoc.utils.L;

/**
 * Created by WangQing on 2017/6/9.
 */

public class AOCApplication extends Application {

    Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;

        L.init();
        Fresco.initialize(mContext);
    }
}
