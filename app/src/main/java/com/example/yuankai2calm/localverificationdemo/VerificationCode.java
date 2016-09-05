package com.example.yuankai2calm.localverificationdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by Administrator on 2016/8/30.
 */
public class VerificationCode {

    private static final char[] CHARS = {
            '0', '1', '2', '3', '4', '5', '6', '7','8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i','j', 'k','l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v','w', 'x','y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };


    /**
     * 单例模式
     */
    private static VerificationCode verificationCode;

    private VerificationCode(){}
    public static VerificationCode getInstance(){

        if(verificationCode == null){

            verificationCode = new VerificationCode();
        }

        return verificationCode;
    }

    //default settings
    private static final int DEFAULT_CODE_LENGTH = 4;//验证码的长度，这里是4位
    private static final int DEFAULT_FONT_SIZE = 60;//字体大小
    private static final int DEFAULT_LINE_NUMBER = 3;//多少条干扰线
    private static final int BASE_PADDING_LEFT = 20; //左边距
    private static final int RANGE_PADDING_LEFT = 35; //左边距范围值
    private static final int BASE_PADDING_TOP = 42; //上边距
    private static final int RANGE_PADDING_TOP = 15; //上边距范围值
    private static final int DEFAULT_WIDTH = 220; //默认宽度，图片的总宽
    private static final int DEFAULT_HEIGHT = 70; //默认高度，图片的总高
    private final int DEFAULT_COLOR = 0xdf; //默认背景颜色值

    //setttings decided by the layout xml
    //canvas width and height
    private int width = DEFAULT_WIDTH;
    private int height = DEFAULT_HEIGHT;

    //random word space and padding_top  字体间隙的空间是随机的
    private int base_padding_left = BASE_PADDING_LEFT;
    private int range_padding_left = RANGE_PADDING_LEFT;
    private int base_padding_top = BASE_PADDING_TOP;
    private int range_padding_top = RANGE_PADDING_TOP;

    //number of chars， lines, font size
    private int codeLength = DEFAULT_CODE_LENGTH;
    private int line_number = DEFAULT_LINE_NUMBER;
    private int font_size = DEFAULT_FONT_SIZE;

    //variables
    private String code; //保存生成的验证码
    private int padding_left, padding_top;
    private Random random = new Random();


    private Bitmap createBitmap(){

        padding_left = 0;

        //创建bitmap图片对象和画布Canvas对象。指定了画布draw into 的对象是指定的bitmap;
        Bitmap bp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bp);

        //随机生成的验证码
        code = createVerificationCode();

        //画笔设置颜色和字体大小
        c.drawColor(Color.rgb(DEFAULT_COLOR, DEFAULT_COLOR, DEFAULT_COLOR));
        Paint paint = new Paint();
        paint.setTextSize(font_size);

        for(int i = 0; i<code.length(); i++){
            randomTextStyle(paint);
            randomPadding();

            //画布用特定的画笔 paint 在其始位置x (padding_left) y(padding_top)写入字符code.charAt(i);
            c.drawText(code.charAt(i) + "", padding_left, padding_top, paint);
        }

        for(int i = 0; i<line_number; i++){

            drawLine(c, paint);
        }

        c.save(Canvas.ALL_SAVE_FLAG);
        c.restore();

        return bp;
    }

    //获取随机字符
    private String createVerificationCode(){

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i<codeLength; i++){
            //从CHARS数组中随机获取到codeLength个字符
            builder.append(CHARS[random.nextInt(CHARS.length)]);
        }

        return builder.toString();
    }

    //转换为小写字母
    public String getCode(){

        return code.toLowerCase();
    }

    //获取制作好的验证码图片
    public Bitmap getBitmap(){

        return createBitmap();
    }

    //在图片中绘制干扰线
    private void drawLine(Canvas canvas, Paint paint){

        //设置画笔的颜色，起点和终点的坐标。画线的线粗细。
        int color = randomColor();
        int startX = random.nextInt(width);
        int startY = random.nextInt(height);
        int stopX = random.nextInt(width);
        int stopY = random.nextInt(height);
        paint.setStrokeWidth(1);
        paint.setColor(color);
        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }

    //随机颜色
    private int randomColor(){

        return randomColor(1);
    }

    private int randomColor(int rate){

        int red = random.nextInt(256)/rate;
        int green = random.nextInt(256)/rate;
        int blue = random.nextInt(256)/rate;

        return Color.rgb(red, green, blue);
    }

    //设置字体的随机格式
    private void randomTextStyle(Paint paint){

        int color = randomColor();
        paint.setColor(color);
        paint.setFakeBoldText(random.nextBoolean());//true为粗体，false为费粗体
        float skewX = random.nextInt(11) /10;
        skewX = random.nextBoolean()? skewX: -skewX;
        paint.setTextSkewX(skewX);//float类型参数，负数表示右斜，正数表示左斜

    }

    private void randomPadding(){

        padding_left += base_padding_left + random.nextInt(range_padding_left);
        padding_top = base_padding_top + random.nextInt(range_padding_top);
    }

}
