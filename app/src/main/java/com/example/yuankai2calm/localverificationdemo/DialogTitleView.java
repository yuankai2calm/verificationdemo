package com.example.yuankai2calm.localverificationdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/9/2.
 */
public class DialogTitleView extends FrameLayout {

    public TextView titleTv;
    public TextView subTitleTv;
    public LinearLayout buttonWell;
    public View titleDivider;

    public static final int MODE_SMALL = 1;
    public static final int MODE_REGULAR = 0;

    public DialogTitleView(Context context){
        super(context);
        init();
    }

    public DialogTitleView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public DialogTitleView(Context context, AttributeSet attrs, int defStyle){

        super(context, attrs, defStyle);
        init();
    }

    private void init(){

        inflate(getContext(), R.layout.view_dialog_header, this);
        titleTv = (TextView) findViewById(R.id.title_tv);
        subTitleTv = (TextView) findViewById(R.id.subtitle_tv);
        buttonWell = (LinearLayout) findViewById(R.id.button_well);
        titleDivider = findViewById(R.id.title_divder);
    }

    //添加点击事件
    public void addAction(View view, OnClickListener listener){

        view.setOnClickListener(listener);
        buttonWell.addView(view);
    }

    //设置模式
    public void setMode(int mode){

        int padding = (int)getContext().getResources().getDimension(R.dimen.global_dialog_padding);
        if(mode == MODE_SMALL){

            buttonWell.removeAllViews();
            buttonWell.setVisibility(View.VISIBLE);
            titleTv.setTextSize(1, 16f);
            padding /= 2;
        }else{

            titleTv.setTextSize(1, 22f);
        }

        titleTv.setPadding(padding, padding, padding, padding);
    }


}
