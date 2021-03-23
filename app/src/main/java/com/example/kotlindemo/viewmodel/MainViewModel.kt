package com.example.kotlindemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.kotlindemo.bean.Repo
import com.example.kotlindemo.paging.Repository
import kotlinx.coroutines.flow.Flow


class MainViewModel :ViewModel(){

    fun getPagingData():Flow<PagingData<Repo>>{

        return Repository.getPagingData().cachedIn(viewModelScope)
    }
}