package com.example.kotlin_study


/**
 * 所谓 的高阶 函数
 */
fun main(){
    //用户
    loginAction("hello","123"){
        if (it) print("登录成功")else print("登录失败")
    }

}

fun loginAction(userName:String,userPassword:String ,loginResponseResult:(Boolean)->Unit){
    loginEngine(userName,userPassword,loginResponseResult)
}

//真正的登录引擎
private  fun loginEngine(userName: String,userPassword: String,loginResponseResult: (Boolean) -> Unit){
    if ("hello"==userName&&"123456"==userPassword){
        loginResponseResult(true)
    }else{
        loginResponseResult(false)
    }
}