package com.zkteam.aoc.activity;

import android.os.Build;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.facebook.fresco.helper.utils.DensityUtil;
import com.zkteam.aoc.R;
import com.zkteam.aoc.base.BaseActivity;
import com.zkteam.aoc.utils.MockTestData;
import com.zkteam.aoc.view.ZKTeamFrescoView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Doraemon on 2017/6/13.
 */

public class CardViewShowActivity extends BaseActivity {
    @BindView(R.id.fresco_view)
    ZKTeamFrescoView frescoView;
    @BindView(R.id.cardview2)
    CardView cardView;
    @BindView(R.id.textView2)
    TextView textView;
    @BindView(R.id.fresco_view1)
    ZKTeamFrescoView frescoView1;
    @BindView(R.id.ib_back)
    ImageButton backIb;


    private int clickCount = -1;


    @Override
    protected int getLayout() {
        return R.layout.activity_show_cardview;
    }

    @Override
    protected void initData() {
        loadImage(frescoView, MockTestData.beautyPics[1]);
        backIb.setVisibility(View.GONE);
    }

    @OnClick({R.id.cardview2, R.id.ib_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cardview2:
                if (clickCount < 12) {
                    clickCount++;

                } else {

                }
                break;
//            case R.id.ib_back:
//                if (clickCount > -1) {
//                    clickCount--;
//                }
//                break;
        }
        changeByClick(clickCount);
    }

    private void changeByClick(int count) {
        switch (count) {
            case -1:
                textView.setText("Default CardView_Click Me!");
                break;
            case 0:
                cardView.setCardElevation(0);
                cardView.setRadius(0);
                textView.setText("CardView extends FrameLayout！Go on!");
                break;
            case 1:
                cardView.setRadius(DensityUtil.dipToPixels(this, 10));
                textView.setText("加了个圆角！Go on!");
                break;
            case 2:
                cardView.setCardElevation(DensityUtil.dipToPixels(this, 10));
                textView.setText("加了个阴影！Go on!");
                break;
            case 3:
                //TODO setBackgroundColor/setBackgroundResource 加背景色导致圆角消失，再次设置圆角也没用
//                cardView.setBackgroundColor(getResources().getColor(R.color.mediumslateblue));
//                textView.setText("加了个背景色__Go on!\n圆角没有了！！");
//                cardView.setCardElevation(10);
                cardView.setCardBackgroundColor(getResources().getColor(R.color.mediumslateblue));
                textView.setText("加了个背景色！Go on!");
                break;
            case 4:
                cardView.setCardBackgroundColor(getResources().getColor(R.color.white));
                frescoView1.setVisibility(View.VISIBLE);
                loadImage(frescoView1, MockTestData.beautyPics[0]);
                textView.setText("显示个图片！Go on!");
                break;
            case 5:
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
                    //TODO 低版本显示问题
                    textView.setText("API19的测试机显示圆角不对!自己玩去吧~");
                } else {
                    textView.setText("Go on!");
                }
                break;
            case 6:
                int padding = DensityUtil.dipToPixels(this, 10f);
                cardView.setContentPadding(padding, padding, padding, padding);
                textView.setText("设置padding,文字不要太靠边！Go on!");
                break;
            case 7:
                cardView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
                cardView.getLayoutParams().height = DensityUtil.dipToPixels(this, 50);
                cardView.setRadius(DensityUtil.dipToPixels(this, 10));
                cardView.setContentPadding(0, 0, 0, 0);
                textView.setText("图片不能全覆盖了，单独设置文字属性!Go on!");
                textView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
                textView.setGravity(Gravity.CENTER);
                break;
            case 8:
                cardView.getLayoutParams().width = DensityUtil.dipToPixels(this, 100);
                cardView.getLayoutParams().height = DensityUtil.dipToPixels(this, 100);
                cardView.setRadius(DensityUtil.dipToPixels(this, 50));
                textView.setText("听说还能变个简单圆形。");
                textView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
                break;
            case 9:
                cardView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
                cardView.getLayoutParams().height = DensityUtil.dipToPixels(this, 50);
                cardView.setRadius(DensityUtil.dipToPixels(this, 10));
                cardView.setContentPadding(0, 0, 0, 0);
                textView.setText("凑合用吧~还是做Item比较好！Go on!");
                break;
            case 10:
                break;
            case 11:
                //TODO 跳转淘宝店铺推荐切换效果
                break;
            case 12:
                //TODO 跳转滚动式卡片
                break;
        }
    }

}
