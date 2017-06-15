package com.zkteam.aoc.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zkteam.aoc.R;
import com.zkteam.aoc.adapter.CategoryAdapter;
import com.zkteam.aoc.base.BaseActivity;
import com.zkteam.aoc.utils.MockTestData;

import butterknife.BindView;

/**
 * CategoryActivity
 * Created by WangQing on 2017/6/10.
 */

public class CategoryActivity extends BaseActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected int getLayout() {
        return R.layout.activity_category;
    }

    @Override
    protected void initData() {

//        recyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new GridLayoutManager(mContext,3));
//        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(new CategoryAdapter(this,R.layout.item_fragment_categroy, MockTestData.getTestPeopleData()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
