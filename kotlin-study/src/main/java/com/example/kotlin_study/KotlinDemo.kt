package com.example.kotlin_study

/**
 * Created on 2021/6/12
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
class KotlinDemo {
}

fun main(){

    var list:MutableList<out Person> = ArrayList<Student>()
    var listDemo:MutableList<in Student> = ArrayList<Person>()


}