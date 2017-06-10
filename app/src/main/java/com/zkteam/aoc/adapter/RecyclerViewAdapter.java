package com.zkteam.aoc.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.fresco.helper.ImageLoader;
import com.zkteam.aoc.R;
import com.zkteam.aoc.utils.MockTestData;
import com.zkteam.aoc.view.ZKTeamFrescoView;

import java.util.List;

public class RecyclerViewAdapter extends BaseQuickAdapter<MockTestData.People, BaseViewHolder>{


    public RecyclerViewAdapter(int layoutResId, @Nullable List<MockTestData.People> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MockTestData.People people) {
        baseViewHolder.setText(R.id.name, people.name);

        ZKTeamFrescoView frescoView = baseViewHolder.getView(R.id.fresco_view);
        ImageLoader.loadImage(frescoView, people.getPicUrl());
    }
}
