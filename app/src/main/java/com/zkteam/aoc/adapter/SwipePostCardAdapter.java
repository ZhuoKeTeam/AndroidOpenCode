package com.zkteam.aoc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.fresco.helper.ImageLoader;
import com.zkteam.aoc.R;
import com.zkteam.aoc.utils.MockTestData;
import com.zkteam.aoc.view.SwipePostcardView;
import com.zkteam.aoc.view.ZKTeamFrescoView;

import java.util.List;

/**
 * Created by Doraemon on 2017/6/16.
 */

public class SwipePostCardAdapter extends SwipePostcardView.Adapter {
    private final String TAG = SwipePostCardAdapter.class.getSimpleName();
    private Context mContext;
    private List<MockTestData.People> mData;

    public SwipePostCardAdapter(Context context, List<MockTestData.People> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public View createView(ViewGroup parent) {
        return LayoutInflater.from(mContext).inflate(R.layout.item_show_cardview, parent, false);
    }

    @Override
    public void bindView(View view, final int position) {
        MockTestData.People people = mData.get(position);
        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        ImageLoader.loadImage(holder.frescoView, people.getPicUrl());
    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

    static class ViewHolder {
        ZKTeamFrescoView frescoView;

        ViewHolder(View view) {
            frescoView = (ZKTeamFrescoView) view.findViewById(R.id.fresco_view);
        }
    }

}
