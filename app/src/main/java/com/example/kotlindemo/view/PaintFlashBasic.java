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
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;


/**
 * Paint的使用
 */
public class PaintFlashBasic extends View {

    private Paint mPaint;

    public PaintFlashBasic(Context context) {
        super(context);
        mPaint=new Paint();
    }

    public PaintFlashBasic(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();

    }

    public PaintFlashBasic(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint=new Paint();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //跳动的 线条
        drawPathEffect(canvas);

    }


    /**
     * 绘制一条跳动的线
     */
    private float phase;
    private PathEffect[] effects;
    private int [] colors;

    private void  drawPathEffect(Canvas canvas){

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);

        //创建 并初始化path
        Path path=new Path();
        path.moveTo(0,0);
        for (int i=1;i<=55;i++){
            //随机 生成35个点 ，并把他们连城一条线
            path.lineTo(i*20,(float)Math.random()*60);
        }

        //初始化 7个颜色
        colors=new int[]{Color.BLACK,Color.CYAN,Color.GRAY,Color.GREEN,Color.RED,Color.MAGENTA,Color.BLUE};
        //背景填充成白色
        canvas.drawColor(Color.WHITE);
        effects=new PathEffect[7];
        //初始化7中路径效果
        // 使用CornerPathEffect路径效果
        effects[1] = new CornerPathEffect(10);
        // 初始化DiscretePathEffect
        effects[2] = new DiscretePathEffect(3.0f, 5.0f);
        // 初始化DashPathEffect
        effects[3] = new DashPathEffect(new float[]{20, 10, 5, 10}, phase);
        // 初始化PathDashPathEffect
        Path p = new Path();
        p.addRect(0, 0, 8, 8, Path.Direction.CCW);
        effects[4] = new PathDashPathEffect(p, 12, phase, PathDashPathEffect.Style.ROTATE);
        // 初始化PathDashPathEffect
        effects[5] = new ComposePathEffect(effects[2], effects[4]);
        effects[6] = new SumPathEffect(effects[4], effects[3]);

        //画布移动8 8处绘制
        canvas.translate(8,8);
        //一次使用不同的 7中效果
        //for (int i = 0; i < effects.length; i++) {
            mPaint.setPathEffect(effects[2]);
            mPaint.setColor(colors[2]);
            canvas.drawPath(path,mPaint);
            canvas.translate(0,200);

      //  }
        //
        phase+=1;
        invalidate();
    }
}
