package com.example.kotlindemo.utils;

public class GenericMethodTest {


    /**
     * 泛型方法
     */

    public static <E> void printArray(E [] inputArray){
        //输出数组 元素
        for (E element:inputArray){
            System.out.println("  " +element);
        }
    }




}
