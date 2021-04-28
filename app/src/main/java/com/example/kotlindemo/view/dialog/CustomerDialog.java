package com.example.kotlindemo.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kotlindemo.R;
import com.example.kotlindemo.adapter.MyRecyclerViewAdapter;
import com.example.kotlindemo.adapter.MyTestAdapter;
import com.example.kotlindemo.view.dialog.base.BaseDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 4/12/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public class CustomerDialog extends BaseDialog {

    private RecyclerView recyclerView;
    private MyTestAdapter myRecyclerViewAdapter;
    private Context mContext;
    private List<String> dataList=new ArrayList<>();




    public CustomerDialog(@NonNull Context context) {
        super(context);
        mContext=context;

    }

    public CustomerDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        mContext=context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void init() {
        super.init();
        setContentView(R.layout.customer_dialog_show_second);
        recyclerView=findViewById(R.id.rv_list);
         List<String> dataList=new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            dataList.add(i+"");
        }
        GridLayoutManager linearLayoutManager=new GridLayoutManager(getContext(),5);

        myRecyclerViewAdapter=new MyTestAdapter(getContext(),dataList);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        myRecyclerViewAdapter.setOnclickListener(new MyTestAdapter.ClickBack() {
            @Override
            public void clickListener(String name, int position) {

                myRecyclerViewAdapter.setDefaultItem(position);

                //dismiss();
            }
        });


    }

    /**
     * 初始化数据
     * @param
     * @return
     */
    public void setDataList(){



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
