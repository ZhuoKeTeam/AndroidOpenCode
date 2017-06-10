package com.zkteam.aoc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zkteam.aoc.R;
import com.zkteam.aoc.activity.CategoryActivity;
import com.zkteam.aoc.base.BaseFragment;
import com.zkteam.aoc.utils.MockTestData;
import com.zkteam.aoc.view.ZKTeamFrescoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 第三世界
 * Created by WangQing on 2017/6/9.
 */
public class ThreeFragment extends BaseFragment {

    @BindView(R.id.fresco_view)
    ZKTeamFrescoView frescoView;
    @BindView(R.id.three_entry)
    TextView threeEntry;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_three;
    }

    @Override
    protected void initData() {
        loadImage(frescoView, MockTestData.beautyPics[0]);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.three_entry)
    public void onClick() {
        Intent intent = new Intent(mContext, CategoryActivity.class);
        mContext.startActivity(intent);
    }
}
