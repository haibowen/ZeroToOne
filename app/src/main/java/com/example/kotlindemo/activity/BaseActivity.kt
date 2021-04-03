package com.example.kotlindemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlindemo.R
import com.gyf.immersionbar.ImmersionBar
import com.tencent.mmkv.MMKV

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        //沉浸式状态栏
        ImmersionBar.with(this).init()
        //初始化mmkv
        MMKV.initialize(this)

    }
}