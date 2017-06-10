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

public class ThreeFragment extends Fragment {

    private String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497080731428&di=bf712b665a670dc92e025a6ce0709249&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fwallpaper%2F1601%2F29%2Fc1%2F18028207_1454080279515_800x600.jpg";

    public ThreeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ZKTeamFrescoView frescoView = (ZKTeamFrescoView) view.findViewById(R.id.fresco_view);
        ImageLoader.loadImage(frescoView, url);

    }
}
