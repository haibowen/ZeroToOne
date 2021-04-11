package com.example.kotlin_study

/**
 * Created on 4/6/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
class TestFunction {


    fun show() {

        var a = "hyplo"
        kotlin.run {
            var a = "test"
            println(a)
        }
        println(a)
    }
}