package com.example.yuankai2calm.localverificationdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/9/2.
 *
 * 分享界面dialog;
 */
public class ShareDialog extends CommonDialog implements View.OnClickListener{

    private Context context;
    private String title;
    private String content;
    private String link;

    private ShareDialog(Context context, boolean flag, OnCancelListener listener) {
        super(context, flag, listener);
        this.context = context;
    }

    private ShareDialog(Context context, int defStyle){

        super(context, defStyle);
        this.context = context;
        View shareView = getLayoutInflater().inflate(
                R.layout.dialog_cotent_share, null);
        shareView.findViewById(R.id.ly_share_qq).setOnClickListener(this);
        shareView.findViewById(R.id.ly_share_copy_link)
                .setOnClickListener(this);
        shareView.findViewById(R.id.ly_share_more_option).setOnClickListener(
                this);
        shareView.findViewById(R.id.ly_share_sina_weibo).setOnClickListener(
                this);
        shareView.findViewById(R.id.ly_share_weichat).setOnClickListener(this);
        shareView.findViewById(R.id.ly_share_weichat_circle)
                .setOnClickListener(this);
        setContent(shareView, 0);
    }

    public ShareDialog(Context context){

        this(context, R.style.dialog_bottom);
    }

    @Override
    protected void onCreate(Bundle bundle){

        super.onCreate(bundle);
        getWindow().setGravity(Gravity.BOTTOM);


        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.width = d.getWidth();
        p.height = (int)((d.getHeight())*0.3825);
        getWindow().setAttributes(p);
    }

    //设置需要分享的内容
    public void setShareInfo(String title, String content, String link){

        this.title = title;
        this.content = content;
        this.link = link;
    }

    @Override
    public void onClick(View v){

        switch(v.getId()){
            case R.id.ly_share_weichat_circle:
                shareToWeiChatCircle();
                break;
            case R.id.ly_share_weichat:
                break;
            case R.id.ly_share_sina_weibo:
                break;
            case R.id.ly_share_qq:
                break;
            case R.id.ly_share_copy_link:
                break;

        }

        this.dismiss();
    }

    //分享到朋友圈
    private void shareToWeiChatCircle(){


    }


}
