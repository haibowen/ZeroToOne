package com.example.kotlin_study

/**
 * Created on 2021/6/9
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
class KotlinTest {
    lateinit var name:String

}

fun main(args:ArrayList<String>){
    var name: String? =null

    //强制执行的 会空指针
    name!!.length
    //判断 name 是否为null
    name?.length

    //var
    var test:String="可读可改"
    test="12222"
    val hello:String="444"
    //不可修改
    //hello="333"

    //KT 是静态语言 还是动态语言 KT 是静态语言的
    var age=30
  //  age=""

}

fun test(){

    print("hello world")
}

fun test(name:String){
    print(name)
}

fun  test(name: String,name1:String):String{
    return name+name1
}

fun test(age:Int,the:Int)=age+the