package com.zkteam.aoc.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zkteam.aoc.R;
import com.zkteam.aoc.utils.MockTestData;

import java.util.List;

public class CategoryAdapter extends BaseQuickAdapter<MockTestData.People, BaseViewHolder>{


    public CategoryAdapter(int layoutResId, @Nullable List<MockTestData.People> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MockTestData.People people) {
        baseViewHolder.setText(R.id.name, people.name);

//        baseViewHolder.setBackgroundRes(R.id.card_view, people.getColor());

        CardView cardView = baseViewHolder.getView(R.id.card_view);
        cardView.setBackgroundResource(people.getColor());
//        cardView.setCardBackgroundColor(people.getColor());
    }
}
