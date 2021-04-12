package com.example.kotlindemo.view.dialog.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.example.kotlindemo.R;

/**
 * Created on 4/12/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public  abstract class BaseDialog extends Dialog {
    public BaseDialog(@NonNull Context context) {
        super(context, R.style.BaseDialog);
        init();
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    /**
     * 初始化
     */

    public void init() {

        setContentView(R.layout.customer_dialog_show);
        normalDialog();
    }

    /**
     * 正常话dialog
     */

    private void normalDialog() {

        fixBackground();
        fixSize();
    }

    /**
     * 这是一个测试的方法
     */

    public void  test(){

    }

    /**
     * init 的test
     */

    public void  initTest(){
        fixBackground();
    }

    public void initTest2(){

    }

    /**
     * 修复背景
     */

    private void fixBackground() {

        Window window = getWindow();
        if (null == window) return;
        //去掉白色背景
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    /**
     * 修复大小
     */

    private void fixSize() {
        //获取要显示的宽高
        DisplayMetrics displayMetrics = new DisplayMetrics();
        //留给子类决定view的宽高
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int[] frameSize = onSetupDialogSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
        //去掉默认的padding间距
        getWindow().getDecorView().setPadding(0, 0, 0, 0);

        int location=getLocation();

        getWindow().setGravity(location);
        //设置dialog的宽高
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.width = frameSize[0];
        layoutParams.height = frameSize[1];
        getWindow().setAttributes(layoutParams);

    }

    /**
     * 写一个抽象的方法留有子类去实现
     */

    protected abstract int[] onSetupDialogSize(int screenWidth, int screenHeight);

    /**
     * 设置显示的位置
     *
     */
    protected  abstract  int getLocation();
}
