package com.example.kotlindemo.common

import android.content.Context
import android.content.Intent
import com.example.kotlindemo.activity.NativePageActivity
import com.example.kotlindemo.net.NetWorkManager
import com.example.kotlindemo.net.request.Request
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.FlutterBoostDelegate
import com.idlefish.flutterboost.containers.FlutterBoostActivity
import com.squareup.leakcanary.LeakCanary
import io.flutter.app.FlutterApplication
import io.flutter.embedding.android.FlutterActivityLaunchConfigs


/**
 * Created on 3/8/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
class BaseApplication : FlutterApplication() {

    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        //初始化
        context=applicationContext
        //初始化网络请求
        NetWorkManager.instant.init(Request.HOST)

        //需要先判断手机上是否已经安装了 leakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this)
        FlutterBoost.instance().setup(this, object : FlutterBoostDelegate {
            fun pushNativeRoute(pageName: String?, arguments: HashMap<String?, String?>?) {
                val intent = Intent(FlutterBoost.instance().currentActivity(), NativePageActivity::class.java)
                FlutterBoost.instance().currentActivity().startActivity(intent)
            }

            fun pushFlutterRoute(pageName: String?, arguments: HashMap<String?, String?>?) {
                val intent: Intent = FlutterBoostActivity.CachedEngineIntentBuilder(FlutterBoostActivity::class.java, FlutterBoost.ENGINE_ID)
                        .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.opaque)
                        .destroyEngineWithActivity(false)
                        .url(pageName)
                        .urlParams(arguments as Map<String, Any>?)
                        .build(FlutterBoost.instance().currentActivity())
                FlutterBoost.instance().currentActivity().startActivity(intent)
            }

            override fun pushFlutterRoute(p0: String?, p1: String?, p2: MutableMap<String, Any>?) {
            }

            override fun pushNativeRoute(p0: String?, p1: MutableMap<String, Any>?) {
            }
        }, { engine -> engine.getPlugins() })
    }
}