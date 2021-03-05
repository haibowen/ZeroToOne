package com.example.kotlindemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.MyListAdapter
import com.example.kotlindemo.bean.News
import java.util.*

class HomeFragment : Fragment() {

    private var recyclerView: RecyclerView? = null
    private var arrayList: MutableList<News> = ArrayList()
    private var myListAdapter: MyListAdapter? = null

    private val toolbar: Toolbar? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        var view:View

        view=inflater.inflate(R.layout.fragment_home, container, false);

        return


    }



    /**
     * toolabr的设置
     */
    fun setToolbar() {
//        toolbar = findViewById<Toolbar>(R.id.tool_bar_show)
//        this@MainActivity.setSupportActionBar(toolbar)
    }

    /**
     * mock 网络数据
     */
    fun getData() {
        for (i in 0..9) {


            arrayList.add(News("测试",i))
        }
    }

    /**
     * 处理数据
     */
    fun handleData() {



        recyclerView = findViewById<RecyclerView>(R.id.rv_show_list)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.setLayoutManager(linearLayoutManager)
        myListAdapter = MyListAdapter(arrayList, this@MainActivity)
        recyclerView.setAdapter(myListAdapter)
    }



}