package com.example.yuankai2calm.localverificationdemo;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView verificationImage;//显示验证码的图标
    Button refreshBtn, confirmBtn;//刷新按钮
    String codeValue = ""; //获取验证码的值
    EditText editVerification; //文本框输入的值用来验证；


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verificationImage = (ImageView)findViewById(R.id.imageView);
        verificationImage.setImageBitmap(VerificationCode.getInstance().getBitmap());
        editVerification = (EditText)findViewById(R.id.editText);

        codeValue = VerificationCode.getInstance().getCode();//获取显示的验证码

        refreshBtn = (Button)findViewById(R.id.button2);

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificationImage.setImageBitmap(VerificationCode.getInstance().getBitmap());
                codeValue = VerificationCode.getInstance().getCode();
            }
        });

        confirmBtn = (Button)findViewById(R.id.button);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String editContent = editVerification.getText().toString().trim().toLowerCase();

                if(editContent == null || editContent.equals("")){
                    Toast.makeText(MainActivity.this, "请填写验证码", Toast.LENGTH_SHORT).show();
                }else if(! editContent.equals(codeValue)){

                    Toast.makeText(MainActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "验证码正确", Toast.LENGTH_SHORT).show();

                    //验证码正确跳转到TextStyle页面
                    Intent intent = new Intent(MainActivity.this, TextStyleShow.class);
                    startActivity(intent);
                }
            }
        });


    }
}
