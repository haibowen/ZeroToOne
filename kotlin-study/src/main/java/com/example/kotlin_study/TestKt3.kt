package com.example.kotlin_study

/**
 * Created on 2021/6/12
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
//不能获取 只能修改
class TestKt3<in T> {


    /**
     * 权限控制了  不能获取
     */
//    fun getData(d:T):T?{
//
//    }
//
    fun setData(d:T){

    }
}