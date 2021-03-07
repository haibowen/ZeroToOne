package com.example.kotlindemo.net.exception

import com.google.gson.JsonParseException
import org.json.JSONException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.text.ParseException

/**
 * Created on 3/7/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 *
 *
 * 自定义 异常处理
 */
object CustomException {

    /**
     * 未知错误
     */
    const val Unknown = 1000

    /**
     * 解析 错误
     */
    const val PARSE_ERROR = 1001

    /**
     * 网络错误
     */
    const val NETWORK_ERROR = 1002

    /**
     * 协议错误
     */
    const val HTTP_ERROR = 1003


    fun handleException(e: Throwable): LocalException {
        val ex: LocalException

        if (e is JsonParseException || e is JSONException || e is ParseException) {
            //解析错误
            ex = LocalException(PARSE_ERROR, e.message)

            return ex

        } else if (e is ConnectException) {
            //网络错误
            ex = LocalException(NETWORK_ERROR, e.message)

            return ex
        } else if (e is UnknownHostException || e is SocketTimeoutException) {
            //连接错误
            ex = LocalException(NETWORK_ERROR, e.message)
            return ex
        } else {
            //未知错误
            ex = LocalException(Unknown, e.message)
            return ex
        }

    }

}