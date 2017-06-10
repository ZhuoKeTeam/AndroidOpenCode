package com.zkteam.aoc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.fresco.helper.ImageLoader;
import com.zkteam.aoc.R;
import com.zkteam.aoc.utils.MockTestData;
import com.zkteam.aoc.view.ZKTeamFrescoView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WangQing on 2017/6/9.
 */

public class ThreeFragment extends Fragment {

    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.fresco_view)
    ZKTeamFrescoView frescoView;

    public ThreeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageLoader.loadImage(frescoView, MockTestData.beautyPics[0]);
    }
}
