package com.example.kotlindemo.utils;

/**
 * Created on 4/4/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public class SynchronizeMethods {


    public int num=10;

    /**
     * 普通方法使用 synchronized 修饰
     * 锁住的是同一个对象，不同线程，同一个对象会互斥
     */
    public synchronized void calculate(){
        num+=1;
    }

    /**
     * 静态方法使用 synchronized 修饰，锁住的是类对象，
     * 不同线程不是同一个对象也会互斥
     */
    public static synchronized void sout(){

    }


}
