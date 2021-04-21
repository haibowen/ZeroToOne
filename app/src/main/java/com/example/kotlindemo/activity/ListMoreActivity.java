package com.example.kotlindemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.kotlindemo.R;
import com.example.kotlindemo.adapter.MyTestAdapter;
import com.example.kotlindemo.adapter.MyTestMoreAdapter;
import com.example.kotlindemo.bean.CalendarInfor;

import java.util.ArrayList;
import java.util.List;

public class ListMoreActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private MyTestMoreAdapter myTestAdapter;
    private Button button;

    private List<CalendarInfor> calendarInforsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.rv_show_list);
        button = findViewById(R.id.bt_show);

        for (int i = 0; i < 30; i++) {

            if (i == 0) {
                calendarInforsList.add(new CalendarInfor("测试" + i, 0));

            } else {
                calendarInforsList.add(new CalendarInfor("测试" + i, 1));

            }


        }

        myTestAdapter=new MyTestMoreAdapter(this,calendarInforsList);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myTestAdapter);


    }
}