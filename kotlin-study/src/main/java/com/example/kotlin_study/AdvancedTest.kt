package com.example.kotlin_study

/**
 * 练习一些
 *
 * kotlin的高级用法
 *
 *
 */
class AdvancedTest {

    fun test(a: Int, b: Int) {
        a + b
    }
    fun testPlus(a:Int,b: Int,operation:(Int,Int)->Int): Int{
        return a+b
    }


}