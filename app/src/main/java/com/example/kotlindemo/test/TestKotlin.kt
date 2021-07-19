package com.example.kotlindemo.test

import android.icu.lang.UCharacter
import android.icu.util.VersionInfo
import java.io.File


/**
 * kotlin 学习
 */

class TestKotlin {


    /**
     * 伴生对象
     */
    companion object{
        private const val TAG="TestKotlin"
    }

    /**
     * 属性委托
     */


    /**
     * 匿名函数
     */
    val stringLengthFunc: (String) -> Int = { inTest ->
        inTest.length

    }


    /**
     * 匿名函数的调用
     */

    val stringLength: Int = stringLengthFunc("Android")


    /**
     * 高阶函数    [这个应该也是可以定义在android里]
     */
    fun stringMapper(str: String, mapper: (String) -> Int): Int {
        return mapper(str)
    }


    /**
     *
     * 高阶函数
     */

    //声明一个变量，类型为一个函数
    private var onClickOkListener: (() -> Unit)? = null

    //声明一个变量，类型为一个函数 取消函数
    private var onClickCancelListener: (() -> Unit)? = null

    //声明一个变量，类型为一个函数 重置函数
    private var onResetCodeListener: ((String) -> Unit)? = null

    //添加一个监听方法，参数同样是一个函数 类型与onClickOkListener保持一致
    fun setOnclickListener(
        listener: (() -> Unit)?,
        onClickCancel: (() -> Unit)? = null,
        onResetCodeListener: ((String) -> Unit)? = null
    ) {
        this.onClickOkListener = onClickOkListener
        this.onClickCancelListener = onClickCancelListener
        this.onResetCodeListener = onResetCodeListener
    }

    /**
     * 方法调用
     */
    fun testMethod() {
        onClickOkListener?.invoke()
        onClickCancelListener?.invoke()
        onResetCodeListener?.invoke("android")
    }


    /**
     * 函数设置 多参数的 话，每个参数要占一行
     */
    fun <T> Iterable<T>.joinToString(
        separator:CharSequence=",",
        prefix:CharSequence="",
        postfix:CharSequence=""
    ):String{
        return ""
    }
    var directory: File?=null
          set(value){
              field = value
          }

    //只读属性
    val defaultExtension:String get() = "kt"


    /**
     * 内部函数
     *
     */

    fun dfs(graph: Int){
        fun dfs(current:VersionInfo,visited:MutableSet<VersionInfo>){

        }

    }

    /**
     * 泛型函数
     */
    fun<T> singletonList(item:T):List<T>{
        return ArrayList<T>()
    }



}

fun main() {
    println("这是测试匿名函数" + TestKotlin().stringLength)

    var test = TestKotlin().stringMapper("androidTestKotlin") { it ->
        it.length
    }
    println("这是一个测试高阶函数的$test")

    TestKotlin().setOnclickListener(listener = {

        /**
         * 这里可以写一些逻辑处理
         */
    })

}