package com.example.kotlindemo.view.dialog;

import android.content.Context;
import android.view.Gravity;

import androidx.annotation.NonNull;

import com.example.kotlindemo.R;
import com.example.kotlindemo.view.dialog.base.BaseDialog;

/**
 * Created on 4/12/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public class AnotherDialog extends BaseDialog {


    public AnotherDialog(@NonNull Context context) {
        super(context);

    }

    public AnotherDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);

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
        return Gravity.CENTER;
    }
}
