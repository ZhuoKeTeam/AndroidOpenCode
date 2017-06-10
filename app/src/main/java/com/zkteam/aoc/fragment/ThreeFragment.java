package com.zkteam.aoc.fragment;

import android.widget.TextView;

import com.zkteam.aoc.R;
import com.zkteam.aoc.base.BaseFragment;
import com.zkteam.aoc.utils.MockTestData;
import com.zkteam.aoc.view.ZKTeamFrescoView;

import butterknife.BindView;

/**
 * 第三世界
 * Created by WangQing on 2017/6/9.
 */
public class ThreeFragment extends BaseFragment {

    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.fresco_view)
    ZKTeamFrescoView frescoView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_three;
    }

    @Override
    protected void initData() {
        loadImage(frescoView, MockTestData.beautyPics[0]);
    }

}
