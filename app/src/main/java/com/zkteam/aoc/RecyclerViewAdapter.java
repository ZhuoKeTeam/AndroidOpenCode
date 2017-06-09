package com.zkteam.aoc;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.fresco.helper.ImageLoader;

import java.util.List;

public class RecyclerViewAdapter extends BaseQuickAdapter<MainFragment.People, BaseViewHolder>{


    public RecyclerViewAdapter(int layoutResId, @Nullable List<MainFragment.People> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MainFragment.People people) {
        baseViewHolder.setText(R.id.name, people.name);

        ZKTeamFrescoView frescoView = baseViewHolder.getView(R.id.fresco_view);
        ImageLoader.loadImage(frescoView, people.getPicUrl());
    }
}
