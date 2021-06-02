package com.example.kotlindemo.activity

import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin_study.camerax.CameraXActivity
import com.example.kotlin_study.navigation.DemoActivity
import com.example.kotlindemo.MainActivity
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.FirstPageAdapter
import com.example.kotlindemo.bean.FirstPageBean
import kotlinx.android.synthetic.main.activity_main2.*

class FirstActivity : BaseActivity() {
    private var adapter:FirstPageAdapter?=null
    private var  dataList:MutableList<FirstPageBean>?=ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        /**
         * 初始化 数据
         */
            dataList?.add(FirstPageBean("Viewpager2",Paging3Activity::class.java))
            dataList?.add(FirstPageBean("自定义behavior",BehaviorActivity::class.java))
            dataList?.add(FirstPageBean("去到主页",MainActivity::class.java))
            dataList?.add(FirstPageBean("自定义view",FloatActivity::class.java))
            dataList?.add(FirstPageBean("navigation",DemoActivity::class.java))
            dataList?.add(FirstPageBean("cameraX",CameraXActivity::class.java))
            dataList?.add(FirstPageBean("截屏操作",ViewActivity::class.java))
            dataList?.add(FirstPageBean("约束布局",ConsActivity::class.java))
            dataList?.add(FirstPageBean("自定义view",ClockActivity::class.java))
        /**
         *
         */
        adapter= dataList?.let { FirstPageAdapter(this, it) }
        rv_list_show.layoutManager=GridLayoutManager(this,2)
        rv_list_show.adapter=adapter
    }
}