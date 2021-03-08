package com.example.kotlindemo.common

import android.app.Application
import com.squareup.leakcanary.LeakCanary

/**
 * Created on 3/8/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //需要先判断手机上是否已经安装了 leakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }

        LeakCanary.install(this)
    }
}