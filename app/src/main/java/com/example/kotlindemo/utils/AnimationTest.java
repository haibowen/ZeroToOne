package com.example.kotlindemo.utils;

import java.lang.annotation.Annotation;

/**
 * 注解的使用
 */
public class AnimationTest {


    public static void main(String[] args) {

        //Deprecated  标注的方法 表示要被遗弃
        test();
        testSomething();

        Annotation[] report=AnimationTest2.class.getAnnotations();




    }

    @Deprecated
    public static  void test(){

        System.out.println("这是一个测试的方法");
    }

    @Report(type = 1,level = "hyplo",value = "")
    public static  void testSomething(){
        System.out.println("testSomething");
    }

}
