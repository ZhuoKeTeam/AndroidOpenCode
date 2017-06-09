package com.zkteam.aoc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by WangQing on 2017/6/9.
 */

public class MainFragment extends Fragment {

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardView mCardView = (CardView) view.findViewById(R.id.cardView);

//        mCardView.setRadius(8);//设置图片圆角的半径大小
//        mCardView.setCardElevation(8);//设置阴影部分大小
//        mCardView.setContentPadding(5,5,5,5);//设置图片距离阴影大小

    }
}
