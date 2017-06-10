package com.zkteam.aoc.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zkteam.aoc.R;
import com.zkteam.aoc.adapter.RecyclerViewAdapter;
import com.zkteam.aoc.base.BaseFragment;
import com.zkteam.aoc.utils.MockTestData;

import butterknife.BindView;

/**
 * MainFragment
 * Created by WangQing on 2017/6/9.
 */
public class MainFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initData() {

        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter(R.layout.item_fragment_main, MockTestData.getTestPeopleData()));
    }


}
