package com.example.kotlindemo.net.schedulers

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created on 3/7/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
class SchedulerProvider : BaseSchedulerProvider {
    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()

    }

    override fun <T> applySchedulers(): ObservableTransformer<T, T> {

        return ObservableTransformer { observable ->
            observable.subscribeOn(io()).observeOn(ui())

        }
    }

    companion object {
        val schedulerProvider: SchedulerProvider by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SchedulerProvider()
        }
    }

}