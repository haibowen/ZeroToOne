package com.example.kotlindemo.net.response

import io.reactivex.ObservableTransformer

/**
 * Created on 3/7/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 *
 * 对返回的数据进行处理,区分异常的情况，不必要再去重新判断
 */
class ResponseTransformer {

    companion object {

        /**
         * 处理数据结果
         */

        fun <T> handleResult(): ObservableTransformer<ResponseData<T>, T> {

            return ObservableTransformer { upstream ->
                upstream.onErrorResumeNext(ErrorResumeFunction())
                        .flatMap(ResponseFunction())

            }
        }

    }


}