package com.zkteam.aoc.view;

import android.content.Context;
import android.util.AttributeSet;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 卓客 Team 的自定义 Fresco View
 * Created by WangQing on 2017/6/9.
 */
public class ZKTeamFrescoView extends SimpleDraweeView {
    public ZKTeamFrescoView(Context context, GenericDraweeHierarchy hierarchy) {
        super(context, hierarchy);
    }

    public ZKTeamFrescoView(Context context) {
        super(context);
    }

    public ZKTeamFrescoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZKTeamFrescoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ZKTeamFrescoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
