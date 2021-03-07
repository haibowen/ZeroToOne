package com.example.kotlindemo.net

import com.example.kotlindemo.bean.App
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created on 3/7/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
interface AppService {

    @GET("")
    fun getAppService(): Call<List<App>>


}