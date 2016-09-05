package com.example.yuankai2calm.localverificationdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/1.
 */
public class TextStyleShow extends Activity{


    @BindView(R.id.tv_text_view)
    TextView textShow;
    @BindString(R.string.text_style_content)
    String text;
    @BindView(R.id.iv_image_view)
    ImageView sharePicture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_style_layout);

        //注入
        ButterKnife.bind(this);

        //为文本设置不同的样式
        setStyleForTextView();
    }


    private void setStyleForTextView(){

        SpannableString spannableString = new SpannableString(text);

        //字体颜色
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);
        spannableString.setSpan(foregroundColorSpan, 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置背景色
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.GREEN);
        spannableString.setSpan(backgroundColorSpan, 4, 6, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        //设置字体斜体，粗体，正常，加粗斜体
        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD_ITALIC);
        spannableString.setSpan(styleSpan, 6, 21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //StringkethroughSpan 删除线
        StrikethroughSpan strikeSpan = new StrikethroughSpan();
        spannableString.setSpan(strikeSpan, 21, 32, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置超链接
        URLSpan urlSpan = new URLSpan("http:"+"\\"+"\\"+"www.douban.com"+"\\");
        spannableString.setSpan(urlSpan, 32, 56, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);




        //设置下划线
        UnderlineSpan underlineSpan = new UnderlineSpan();
        spannableString.setSpan(underlineSpan, 56, 64, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //指定文件的大小
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(16);
        spannableString.setSpan(absoluteSizeSpan, 64, 70, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        AbsoluteSizeSpan absoluteSizeSpan1 = new AbsoluteSizeSpan(50);
        spannableString.setSpan(absoluteSizeSpan1, 70, 73, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //下标
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        spannableString.setSpan(subscriptSpan, 73, 77, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        spannableString.setSpan(superscriptSpan, 77, 81, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        //插入图片，ImageSpan图片样式中，主要用于在文不能中插入图片，聊天中的emoji表情显示用的就是这个

        //对于文本设定的大小的相对比例。文本显示是存在一个初始的大小的，现在设置的是相对于初始文本的大小
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.5f);
        spannableString.setSpan(relativeSizeSpan, 81, 86, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        RelativeSizeSpan relativeSizeSpan1 = new RelativeSizeSpan(1.5f);
        spannableString.setSpan(relativeSizeSpan1, 86, 90, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textShow.setText(spannableString);

        sharePicture.setImageResource(R.drawable.jon_snow);
    }

    //点击显示出分享选择的Dialog;
    @OnClick(R.id.ibtn_share)
    public void onClick(View view){
        //分享操作
        handleShare();

    }

    //分享操作
    public void handleShare(){

        ShareDialog dialog = new ShareDialog(this);
        dialog.setCancelable(true);
        dialog.setTitle("分享到");
        dialog.setShareInfo("分享标题", "分享内容", "分享链接");
        dialog.show();
    }

}
