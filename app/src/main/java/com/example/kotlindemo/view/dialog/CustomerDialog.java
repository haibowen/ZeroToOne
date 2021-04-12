package com.example.kotlindemo.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.example.kotlindemo.R;
import com.example.kotlindemo.view.dialog.base.BaseDialog;

/**
 * Created on 4/12/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public class CustomerDialog extends BaseDialog {


    public CustomerDialog(@NonNull Context context) {
        super(context);

    }

    public CustomerDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);

    }

    @Override
    public void init() {
        super.init();
        setContentView(R.layout.customer_dialog_show_second);
    }


    @Override
    protected int[] onSetupDialogSize(int screenWidth, int screenHeight) {

        int[] size = new int[2];
        size[0] = screenWidth;
        size[1] = screenHeight / 2;
        return size;
    }

    @Override
    protected int getLocation() {
        return Gravity.BOTTOM;
    }
}
