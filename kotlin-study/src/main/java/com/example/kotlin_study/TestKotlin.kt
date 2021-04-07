package com.example.kotlin_study


/**
 * kotlin 基础知识 回顾
 */
class TestKotlin(str: String) {


    /**
     *
     *
     *
     *
     *
     *
     *
     * kotlin 中的一些构造函数的使用
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */

    /**
     * 构造函数的是使用
     *
     *主构造函数的初始化 的地方
     *
     */
    init {
        //这里使用 主构造函数的使用
        println("这是名为$str 的实例")
    }


    /**
     * kotlin中的次构造函数要掉用或者间接的调用主构造函数
     */

    constructor(name: String, age: Int) : this("") {

    }

    /**
     *
     *
     *
     *
     *
     *
     *
     *
     * kotlin 中的标准函数的使用
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */


    /**
     * run 的使用
     *
     *
     */
    fun sout() {
        var test = "hyplo"
        kotlin.run {
            var test = "kotlin"
            println(test)
        }
        println(test)
    }

    /**
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * kotlin 中的一些循环使用方式
     *
     *
     *
     *
     *
     *
     *
     */
    /**
     * when的是使用
     */

    fun test(name: String) {
        when (name) {
            "hyplo" -> "test"
            "Android" -> "kotlin"
            "test" -> {
                println("这是测试的数据")
            }
        }
    }

    /**
     * for 循环在kotlin中的使用
     */

    fun testFor() {
        for (i in 1..10) {
            println(i)
        }
    }

    /**
     * until   step  downto
     */

    fun testUntil() {


        //奇数的输出
        kotlin.run {
            for (i in 1 until 10 step 2) {
                println(i)
            }

        }
        //从10递减
        for (i in 10 downTo 1) {
            println(i)
        }

    }

    /**
     *
     *
     *
     * kotlin中集合部分的 函数式 API
     *
     *
     * maxBy
     *
     * map
     *
     *
     * filter
     *
     *
     * any
     *
     * All
     *
     */


    fun testMap() {

        var list = listOf<String>("apple", "samsung", "mi", "huawei", "onePlues")


        var newList = list.map {

            it.toUpperCase()
        }.filter {
            it.length > 5

        }

        for (i in newList) {
            println(i)
        }
    }

    /**
     * kotlin 中的匿名类 不在使用new 关键字 而是使用了 object 关键字
     *
     *
     */

    fun  testThread(){
        Thread(object :Runnable {
            override fun run() {
                //开始的测试
                println("这是新线程的测试")
            }
        }).start()
    }

    fun  testThread2(){
        Thread {
            println("这是lambuda的测试")
        }.start()
    }

}

fun main() {
//    TestKotlin().test("test")
//    TestKotlin().testFor()
//    TestKotlin("hyplo").testUntil()
//
//    SingleTest.testSomething()
    TestKotlin("str").testMap()
    TestKotlin("tst").testThread()
}


/**
 * kiotlin中的数据类默认是做了java中数据类 的操作的 包括重写  equals  hascode  toString  constructor
 */
data class MyNumber(val str: String, val age: Int, val type: String)


/**
kotlin 中的单例类
 **/


object SingleTest {

    fun testSomething() {
        println("这是单例的测试")
    }
}