package com.example.kotlindemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomerToolbar extends RelativeLayout {

    //toolbar 上的左右图片
    private ImageView imageViewLeft,imageViewRight;
    private TextView textView;//标题
    public CustomerToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
