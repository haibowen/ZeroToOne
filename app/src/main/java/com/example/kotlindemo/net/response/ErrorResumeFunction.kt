package com.example.kotlindemo.net.response

import com.example.kotlindemo.net.exception.CustomException
import io.reactivex.ObservableSource
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * Created on 3/7/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 *
 *
 * 非服务器产生的异常， 如本地的无网络请求，json数据解析错误
 */
class ErrorResumeFunction<T>:Function<Throwable,ObservableSource<out ResponseData<T>>> {
    override fun apply(t: Throwable): ObservableSource<out ResponseData<T>> {

        return  Observable.error(CustomException.handleException(t))

    }
}