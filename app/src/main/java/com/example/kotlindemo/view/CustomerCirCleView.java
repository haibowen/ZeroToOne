package com.example.kotlindemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomerCirCleView  extends View {

    private int mColor= Color.RED;
    private Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);


    public CustomerCirCleView(Context context) {
        super(context);
        init();
    }

    public CustomerCirCleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomerCirCleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 设置 初始化
     */

    public void init(){
        paint.setColor(mColor);
    }

    /**
     * 重新绘制
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=getWidth();
        int height=getHeight();
        int radius=Math.min(width,height)/2;
        canvas.drawCircle(width/2,height/2,radius,paint);
    }
}
