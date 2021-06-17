package com.example.kotlin_study

/**
 * Created on 2021/6/10
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */


fun main() {

    val method: (String, String) -> Unit = { aStr, bStr ->
        print("a:$aStr,b:$bStr")
    }

    method("hyplooo","worker")
    val method2={ print("Derry")}
    loginAction("name","password"){
        if (it)print("登录成功")else print("登录失败")
    }

}

fun loginAction(name:String,password:String,loginResponse:(Boolean)->Unit){

    if (name=="hyplo"&&password=="123456"){
        loginResponse(true)
    }else{
        loginResponse(false)
    }
}