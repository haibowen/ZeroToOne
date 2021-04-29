package com.example.kotlindemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

import com.example.kotlindemo.R;
import com.example.kotlindemo.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private List<String> dataList=new ArrayList<>();
    private Button button;

    private ConstraintLayout  constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView=findViewById(R.id.rv_list);
        button=findViewById(R.id.bt_show);
        constraintLayout=findViewById(R.id.cos_show);



        for (int i = 0; i < 13; i++) {
            dataList.add("星期"+i);


        }
        myRecyclerViewAdapter=new MyRecyclerViewAdapter(this,dataList);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);

            }
        });


        addLayoutListener(constraintLayout,button);
        //addLayoutListener(constraintLayout,recyclerView);
    }


    public void addLayoutListener(final View main, final View scroll) {
        main.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();  //1、获取main在窗体的可视区域
                main.getWindowVisibleDisplayFrame(rect);  //2、获取main在窗体的不可视区域高度，在键盘没有弹起时，main.getRootView().getHeight()调节度应该和rect.bottom高度一样
                int mainInvisibleHeight = main.getRootView().getHeight() - rect.bottom;
                int screenHeight = main.getRootView().getHeight();//屏幕高度
                //3、不可见区域大于屏幕本身高度的1/4：说明键盘弹起了
                if (mainInvisibleHeight > screenHeight / 4) {
                    int[] location = new int[2];
                    scroll.getLocationInWindow(location);   // 4､获取Scroll的窗体坐标，算出main需要滚动的高度
                    int srollHeight = (location[1] + scroll.getHeight()) - rect.bottom;   //5､让界面整体上移键盘的高度
                    main.scrollTo(0, srollHeight+40);
                } else {  //3、不可见区域小于屏幕高度1/4时,说明键盘隐藏了，把界面下移，移回到原有高度
                    main.scrollTo(0, 0);
                }
            }
        });
    }
}