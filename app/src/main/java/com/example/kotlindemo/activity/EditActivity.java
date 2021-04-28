package com.example.kotlindemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.kotlindemo.R;
import com.example.kotlindemo.utils.KeyboardChangeListener;

public class EditActivity extends AppCompatActivity {

    private EditText et1;
    private Button button;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        et1=findViewById(R.id.et_show);
        button=findViewById(R.id.bt_show);
        constraintLayout=findViewById(R.id.cos_show);


        DisplayMetrics dm = new DisplayMetrics();

//取得窗口属性

        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int screenHeight = dm.heightPixels;
        LinearLayout.LayoutParams lp1 = (LinearLayout.LayoutParams) constraintLayout.getLayoutParams();

        //根据是否有焦点更新背景（这里只是演示使用，其实这种更换背景的效果可以通过Selector来实现）
        et1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Log.e("abc", "et1获取到焦点了。。。。。。");
                    Log.e("abc", "。。。。。。"+screenHeight);
                    Log.e("abc", "上边距"+lp1.topMargin);

                    setViewLayoutParams(et1,500,400);
                   // button.requestLayout();




                } else {
                    Log.e("abc", "et1失去焦点了。。。。。。");
                }
            }
        });

        KeyboardChangeListener mKeyboardChangeListener = new KeyboardChangeListener(this);
        mKeyboardChangeListener.setKeyBoardListener(new KeyboardChangeListener.KeyBoardListener() {
            @Override
            public void onKeyboardChange(boolean isShow, int keyboardHeight) {
                if (isShow) {
                    lp1.topMargin = -(screenHeight*3/5);

                }else {
                    lp1.topMargin = 60;
                }
                constraintLayout.requestLayout();
            }
        });




    }


    /**
     * 重设 view 的宽高
     */
    public static void setViewLayoutParams(View view, int nWidth, int nHeight) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp.height != nHeight || lp.width != nWidth) {
            lp.width = lp.MATCH_PARENT;
            lp.height = nHeight;
            view.setLayoutParams(lp);
        }
    }


}