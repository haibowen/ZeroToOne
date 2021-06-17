package com.example.kotlin_study

/**
 * Created on 2021/6/12
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
class TestKt2<out T> {

    //只能获取
    fun getData():T?=null

    //不能修改  不能这样声明
//    fun setDAta(d:T){
//
//    }

}