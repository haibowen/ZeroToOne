package com.example.kotlindemo.net.request

import com.example.kotlindemo.bean.App
import com.example.kotlindemo.bean.ArticalData
import com.example.kotlindemo.net.response.ResponseData
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created on 3/7/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
interface Request {

    companion object {
        val HOST = "https://www.wanandroid.com\n"

    }

    @POST("user/sorgs")
    fun getSorgs(@Query("id") id: String): Observable<ResponseData<App>>


    @POST("user/sorgs")
    fun getCallTest(@Query("id") id: String): Call<ResponseData<App>>


    @GET("article/list/{page}/json")
    fun getAllArticle(@Path("page") page: Int): Call<ResponseData<ArticalData>>


}