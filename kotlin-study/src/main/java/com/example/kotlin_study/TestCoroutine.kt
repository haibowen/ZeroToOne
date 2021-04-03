package com.example.kotlin_study

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class TestCoroutine {

}

fun main() {

    //testAdd()
    add()
}

suspend fun one(): Int {

    delay(1500)
    return 1
}

suspend fun two(): Int {
    delay(1500)
    return 2

}

suspend fun three(int: Int): Int {
    delay(1500)
    return 2 + int
}

fun  testAdd(){
    GlobalScope.launch {

        val time = measureTimeMillis {

            val sum = withContext(Dispatchers.IO) {
                val one = async { one() }
                val two = async { two() }
                one.await() + two.await()
            }
            println("计算的结果为$sum")
        }
        println("执行的时间为$time")

    }
    print("--------------")
    Thread.sleep(4000)
}

fun add() {

    GlobalScope.launch {
        val time = measureTimeMillis {

            val sum = withContext(Dispatchers.IO) {
                val one = one()
                val two = three(one)
                one + two
            }
            println("计算的结果为$sum")
        }
        println("执行的时间为$time")

    }

    print("--------------")
    Thread.sleep(4000)
}