package com.zkteam.aoc.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.zkteam.aoc.R;
import com.zkteam.aoc.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ControlDisplayActivity
 * Created by WangQing on 2017/6/13.
 */
public class ControlDisplayActivity extends BaseActivity {

    public static final String FLAG_CATEGORY = "flag_category";

    public static final int FLAG_CATEGORY_TEXT_VIEW = 1;
    @BindView(R.id.edit_text)
    TextInputEditText editText;
    @BindView(R.id.text_size_spinner)
    AppCompatSpinner textSizeSpinner;
    @BindView(R.id.text_color_spinner)
    AppCompatSpinner textColorSpinner;

    @BindView(R.id.control_display_tv)
    TextView controlDisplayTv;

    @Override
    protected int getLayout() {
        return R.layout.activity_control_display;
    }

    @Override
    protected void initData() {
        int category = getIntent().getIntExtra(FLAG_CATEGORY, 0);
        switch (category) {
            case FLAG_CATEGORY_TEXT_VIEW:
                controlDisplayTv.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Resources res = getResources();
        final String[] textSize = res.getStringArray(R.array.text_size);
        final int[] textColor = res.getIntArray(R.array.text_color);
        textSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                float size = Float.parseFloat(textSize[position].replace("sp", ""));
                controlDisplayTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        textColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                controlDisplayTv.setTextColor(textColor[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                controlDisplayTv.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick({R.id.control_display_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.control_display_tv:
                // TODO: 2017/6/13  重置字体
                break;
        }
    }


}
