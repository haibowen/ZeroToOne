package com.example.jetpack;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Created on 5/30/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public class MyLocationListener implements LifecycleObserver {


    public MyLocationListener(Activity context, OnLocationChangedListener onLocationChangedListener) {
        //初始化操作
        iniLocationManager();
    }

    /**
     * 进行一些初始化的操作
     */
    public void iniLocationManager() {

    }

    /**
     * 监听 onResume的生命周期
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void startGetLocation() {
        Log.d("", "开始定位");
    }


    /**
     * 监听 onPause
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void stopGetLocation() {
    }

    /**
     * 地理位置发生变化时，通过该接口通知调用者
     */
    public interface OnLocationChangedListener {
        void onChanged(double latitude, double longitude);
    }
    //其他一些代码
}
