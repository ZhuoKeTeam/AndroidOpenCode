package com.zkteam.aoc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.fresco.helper.ImageLoader;
import com.zkteam.aoc.R;
import com.zkteam.aoc.view.ZKTeamFrescoView;

/**
 * Created by WangQing on 2017/6/9.
 */

public class SecondFragment extends Fragment {

    private static final String TAG = "SecondFragment";


    private String url = "http://www.wsxz.cn/ylzx/uploads/allimg/170504/00523Q211-0.jpg";


    public SecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        ZKTeamFrescoView frescoView = (ZKTeamFrescoView) view.findViewById(R.id.fresco_view);
        ImageLoader.loadImage(frescoView, url);

    }
}
