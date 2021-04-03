package com.example.kotlindemo.activity

import Screen2Fragment
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.ViewPager2Adapter
import com.example.kotlindemo.fragment.Screen3Fragment
import com.example.kotlindemo.fragment.ScreenFragment
import kotlinx.android.synthetic.main.activity_view_pager2.*

class ViewPager2Activity : AppCompatActivity() {


    var list: MutableList<Fragment> = ArrayList<Fragment>()
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)



        list.add(ScreenFragment())
        list.add(Screen2Fragment())
        list.add(Screen3Fragment())

        vp_show_2.let {
            it.adapter = ViewPager2Adapter(this, list)
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()


    }
}