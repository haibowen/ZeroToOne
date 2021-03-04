package com.example.kotlindemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kotlindemo.bean.News;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<News> arryList = new ArrayList<>();
    private MyListAdapter myListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();

        handleData();


    }

    /**
     * mock 网络数据
     */

    public void getData() {
        for (int i = 0; i < 10; i++) {
            arryList.add(new News("测试", i));
        }
    }

    /**
     * 处理数据
     */

    public void handleData() {
        recyclerView = findViewById(R.id.rv_show_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        myListAdapter = new MyListAdapter(arryList, MainActivity.this);
        recyclerView.setAdapter(myListAdapter);

    }
}