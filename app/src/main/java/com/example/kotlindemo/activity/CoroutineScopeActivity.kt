package com.example.kotlindemo.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.R
import com.example.kotlindemo.common.BaseApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CoroutineScopeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_scope)



    }

    fun test() {
        val coroutineScope= CoroutineScope(Dispatchers.Main)
        coroutineScope.launch {
            Log.e("test","")

            launch (Dispatchers.IO){


                Log.e("tessst",""+Thread.currentThread().id)
                //网络请求
            }
        }
    }
}