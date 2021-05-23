package com.example.kotlindemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created on 5/23/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public class FlutterRender {


    public  native  void init(SurfaceView surfaceView);




    class LinearShow extends View{


        public LinearShow(Context context) {
            super(context);
        }

        public LinearShow(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
        }
    }
}
