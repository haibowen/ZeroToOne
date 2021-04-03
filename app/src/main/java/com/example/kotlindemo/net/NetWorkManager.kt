package com.example.kotlindemo.net

import com.example.kotlindemo.BuildConfig
import com.example.kotlindemo.net.request.Request
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created on 3/7/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
class NetWorkManager {

    companion object {

        var retrofit: Retrofit? = null

        //单例获取
        val instant: NetWorkManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { NetWorkManager() }
        val request: Request? by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            retrofit?.create(com.example.kotlindemo.net.request.Request::class.java)
        }

    }

    /**
     * 初始化必要对象和参数
     *
     */

    fun init(baseUrl: String) {

        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) {

            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }

        //初始化 okhttp
        val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

        //初始化 Retrofit
        retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()


    }


}