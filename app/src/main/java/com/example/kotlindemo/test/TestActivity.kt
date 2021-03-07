package com.example.kotlindemo.test

import android.app.DownloadManager
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.R
import com.example.kotlindemo.bean.App
import com.example.kotlindemo.net.NetWorkManager
import com.example.kotlindemo.net.request.Request
import com.example.kotlindemo.net.response.ResponseData
import com.example.kotlindemo.net.response.ResponseTransformer
import com.example.kotlindemo.net.schedulers.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_test.*
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created on 3/7/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
class TestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContentView(R.layout.activity_test)

        NetWorkManager.instant.init(Request.HOST)

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        //初始化okhttp
        val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

        bt_show.setOnClickListener {

            NetWorkManager.request?.getSorgs("2")
                    ?.compose(ResponseTransformer.handleResult())
                    ?.compose(SchedulerProvider.schedulerProvider.applySchedulers())
                    ?.subscribe({ App ->
                        Log.i("", "")

                    }, { t ->
                        Log.e("", "")

                    })

        }

        bt_show.setOnClickListener {

            //c初始化 retrofit

            val request = Retrofit.Builder()
                    .client(client)
                    .baseUrl(Request.HOST)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(Request::class.java)

            request.getSorgs("1")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ t ->
                        Log.e("", "")
                    }, { e ->
                        Log.e("", "")
                    })
        }

        bt_show.setOnClickListener {

            //初始化Retrofit
            val request = Retrofit.Builder()
                    .client(client)
                    .baseUrl(Request.HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            val callApi = request.create(Request::class.java)
            callApi.getCallTest("1").enqueue(object : Callback<ResponseData<App>> {
                override fun onResponse(call: Call<ResponseData<App>>, response: retrofit2.Response<ResponseData<App>>) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<ResponseData<App>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }


    }
}