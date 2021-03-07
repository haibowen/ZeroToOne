package com.example.kotlindemo.net.response


import com.example.kotlindemo.net.exception.LocalException
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.Function

/**
 * Created on 3/7/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 *
 *
 *
 * 服务器返回的 数据解析
 * 正常服务器返回数据 和服务器可能返回的 exception
 *
 */
class ResponseFunction<T> : Function<ResponseData<T>, ObservableSource<T>> {
    override fun apply(t: ResponseData<T>): ObservableSource<T> {
        val code = t.code
        val message = t.msg

        return if (code == 200) {
            Observable.just(t.data)
        } else {
            Observable.error(LocalException(code, message))
        }

    }

}