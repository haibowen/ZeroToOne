package com.example.kotlindemo.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * service 使用测试
 *
 *
 * stopSelf stopService  会执行 onDestroy 代表Service 生命周期结束
 *
 */
class MyService : Service() {


    override fun onCreate() {
        super.onCreate()

        Log.e("serviceTest","这是 service的onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.e("serviceTest","这是service的测试")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()


    }

    override fun onBind(intent: Intent?): IBinder? {


        return null

    }
}