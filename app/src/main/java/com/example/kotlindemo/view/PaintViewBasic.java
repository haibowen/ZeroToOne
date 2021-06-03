package com.example.kotlindemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


/**
 * Paint的使用
 */
public class PaintViewBasic extends View {

    private Paint mPaint;

    public PaintViewBasic(Context context) {
        super(context);
        mPaint=new Paint();
    }

    public PaintViewBasic(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();

    }

    public PaintViewBasic(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint=new Paint();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画笔的使用
        drawStyle(canvas);
        //线帽的使用
      //  drawStrokeCap(canvas);
    }

    /**
     * drawStyle
     *
     *  画笔的样式 设置
     */
    private void drawStyle(Canvas canvas){

        mPaint.setColor(Color.GRAY);//画笔的颜色
        mPaint.setTextSize(60);//文字的大小
        mPaint.setStrokeWidth(5);//画笔的宽度
        mPaint.setAntiAlias(true);//抗锯齿
        //第一个环
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(200,200,160,mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(400,200,160,mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(600,200,160,mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(800,200,160,mPaint);
    }

    /**
     * 设置 线帽的样式
     */
    private void drawStrokeCap(Canvas canvas){
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(200);
        paint.setColor(Color.GRAY);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(200,500,500,500,paint);

    }
}
