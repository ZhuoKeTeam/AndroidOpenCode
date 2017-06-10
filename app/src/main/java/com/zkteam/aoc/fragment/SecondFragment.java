package com.zkteam.aoc.fragment;

import android.widget.TextView;

import com.zkteam.aoc.R;
import com.zkteam.aoc.base.BaseFragment;
import com.zkteam.aoc.utils.MockTestData;
import com.zkteam.aoc.view.ZKTeamFrescoView;

import butterknife.BindView;

/**
 * SecondFragment
 * Created by WangQing on 2017/6/9.
 */

public class SecondFragment extends BaseFragment {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.fresco_view)
    ZKTeamFrescoView frescoView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_second;
    }

    @Override
    protected void initData() {
        loadImage(frescoView, MockTestData.beautyPics[1]);
    }

}
