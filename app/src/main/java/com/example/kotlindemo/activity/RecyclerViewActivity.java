package com.example.kotlindemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView=findViewById(R.id.rv_list);
        button=findViewById(R.id.bt_show);


        for (int i = 0; i < 20; i++) {
            dataList.add("星期"+i);


        }
        myRecyclerViewAdapter=new MyRecyclerViewAdapter(this,dataList);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);

            }
        });
    }
}