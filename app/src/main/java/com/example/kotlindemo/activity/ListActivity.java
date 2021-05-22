package com.example.kotlindemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kotlindemo.R;
import com.example.kotlindemo.adapter.MyTestAdapter;
import com.example.kotlindemo.utils.CenterLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyTestAdapter myTestAdapter;
    private Button button;
    private List<String> dataList = new ArrayList<>();
    private int i = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.rv_show_list);
        button = findViewById(R.id.bt_show);
        for (int i = 0; i <= 40; i++) {
            dataList.add("测试" + i);
        }
        myTestAdapter = new MyTestAdapter(this, dataList);
        CenterLayoutManager linearLayoutManager = new CenterLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myTestAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 2 * i;
                recyclerView.smoothScrollToPosition(i);
                myTestAdapter.setDefaultItem(i);
                String name = myTestAdapter.getDataList().get(i);
                Toast.makeText(ListActivity.this, name, Toast.LENGTH_SHORT).show();
                myTestAdapter.setOnclickListener(new MyTestAdapter.ClickBack() {
                    @Override
                    public void clickListener(String name, int position) {
                    }
                });
            }
        });

    }
}