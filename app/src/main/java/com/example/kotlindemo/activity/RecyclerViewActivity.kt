package com.example.kotlindemo.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.MyRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_recycler_view.*
import java.util.*

class RecyclerViewActivity : AppCompatActivity() {
    private var myRecyclerViewAdapter: MyRecyclerViewAdapter? = null
    private val dataList: MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        for (i in 0..19) {
            dataList.add("星期$i")
        }
        myRecyclerViewAdapter = MyRecyclerViewAdapter(this, dataList)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.HORIZONTAL
        rv_list.setLayoutManager(linearLayoutManager)
        rv_list.setAdapter(myRecyclerViewAdapter)

        cos_show.setOnClickListener{
            Log.e("ViewActivity","图片点击了")
        }
    }
}