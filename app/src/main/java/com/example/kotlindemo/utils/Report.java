package com.example.kotlindemo.utils;


/**
 * 注解的定义
 */
public @interface Report {


    int type() default 0;

    String level() default "info";

    String value() default "";

}
