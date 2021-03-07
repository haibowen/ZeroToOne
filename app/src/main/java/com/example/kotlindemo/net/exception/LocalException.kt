package com.example.kotlindemo.net.exception

/**
 * Created on 3/7/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
class LocalException : Exception {


    var code:Int=0
    var displayMessage :String?=null

    constructor(code:Int,displayMessage:String?){
        this.code=code
        this.displayMessage=displayMessage
    }

    constructor(code: Int,message:String,displayMessage: String?):super(message){
        this.code=code
        this.displayMessage=displayMessage
    }

}