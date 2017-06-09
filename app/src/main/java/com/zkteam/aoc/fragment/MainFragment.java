package com.zkteam.aoc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zkteam.aoc.R;
import com.zkteam.aoc.adapter.RecyclerViewAdapter;
import com.zkteam.aoc.utils.MockTestData;

import java.util.ArrayList;
import java.util.List;

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
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

//        CardView mCardView = (CardView) view.findViewById(R.id.cardView);
//        mCardView.setRadius(8);//设置图片圆角的半径大小
//        mCardView.setCardElevation(8);//设置阴影部分大小
//        mCardView.setContentPadding(5,5,5,5);//设置图片距离阴影大小


        List<People> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            People p = new People();
            p.setName(MockTestData.picNames[i % 10]);
            p.setAge("" + i);
            p.setPicUrl(MockTestData.picUrls[i % 10]);
            list.add(p);
        }

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new RecyclerViewAdapter(R.layout.item_fragment_main, list));
    }

    public static class People {
        public String name;
        public String age;
        public String picUrl;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }
    }
}
