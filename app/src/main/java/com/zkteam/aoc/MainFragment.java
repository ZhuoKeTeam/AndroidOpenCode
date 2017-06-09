package com.zkteam.aoc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangQing on 2017/6/9.
 */
public class MainFragment extends Fragment {


    private String [] picNames = new String[]{
            "彩色星空",
            "猎空星座",
            "宇宙星球",
            "夜色山空",
            "星空棒棒糖",
            "海绵宝宝星空糖",
            "巧克力",
            "口袋巧克力漫画",
            "奇闻轶事",
            "欧美男模",
    };
    private String [] picUrls = new String[]{
            "http://pic.qiantucdn.com/58pic/19/74/30/57108f7f385ad_1024.jpg",
            "http://pic.qiantucdn.com/58pic/15/13/70/16M58PICa6B_1024.jpg",
            "http://pic31.photophoto.cn/20140519/0022005818922971_b.jpg",
            "http://attach.bbs.miui.com/forum/201508/13/222400pwwz3wgu8odz3wvg.jpg.thumb.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497035920606&di=de99aa27d160b6694c8f1c59fe7efec6&imgtype=0&src=http%3A%2F%2Fwww.5888.tv%2FUpload_Map%2Fpinpai%2F2016%2F1-5%2F2016010510275928.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1167138641,4151807500&fm=26&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497036007917&di=b03bb7d1a0c9ca8a1a25933e1b1b9363&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201403%2F02%2F20140302232649_xHPGL.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497036046719&di=89b7ecb332f1cf67c857ef38614c1cc4&imgtype=0&src=http%3A%2F%2Fs7.sinaimg.cn%2Fmw690%2F001yjtpDgy6EiEyM80646%26690",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497036083689&di=57181cac7a885b0f8902b170ad77ef22&imgtype=0&src=http%3A%2F%2Fwww.gd188.cn%2Ffile%2Fupload%2F201705%2F10%2F10%2F10-12-57-57-1.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497036138783&di=bb59e216f717165d40f58820c729f574&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201502%2F24%2F20150224142121_axcUN.jpeg",
    };


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
            p.setName(picNames[i % 10]);
            p.setAge("" + i);
            p.setPicUrl(picUrls[i % 10]);
            list.add(p);
        }

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new RecyclerViewAdapter(R.layout.item_fragment_main, list));
    }

    public static class People {
        String name;
        String age;
        String picUrl;

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
