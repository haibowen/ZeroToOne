package com.example.kotlin_study

class Lambda {
}


/**
 * lambda测试
 */

fun  main(){


    //KT中的 lambda更加强大
    val method:(String ,String )->Unit={arg1,arg2-> println("arg1:$arg1,b:$arg2")}
    method("hyplo","test")

    val method1={println("这是一个测试")}
    method1()

    val method2:(String)->Unit={
        println("输入你要传入的值$it")
    }
    method2("kotlin")

    var method3:(Int)->Unit={
        when(it){
            1-> println("这是$it")
            in 20..30-> println("这是20-30的数字")
            else-> println("都不满足")
        }
    }
    method3(1)
    method3(5)
    method3(99)

    var method4:(Int ,Int)->Unit={
        aNumber,_->
        println("这是废弃参数的测试$aNumber")
    }
    method4(20,45)

    var method5:(String)->String= {
        str->str
    }
    println( method5("hyhh")
    )

}