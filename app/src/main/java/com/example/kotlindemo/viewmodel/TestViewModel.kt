package com.example.kotlindemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlindemo.bean.App

class TestViewModel:ViewModel() {

    var userLiveData= MutableLiveData<App>()
    var appName : LiveData<String> = Transformations.map(userLiveData){

        app->app.name
    }





}