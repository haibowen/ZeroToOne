package com.example.kotlindemo.net.schedulers

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler

/**
 * Created on 3/7/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 *
 * 切换线程的线程定义
 */
interface BaseSchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler

    fun <T> applySchedulers(): ObservableTransformer<T, T>

}