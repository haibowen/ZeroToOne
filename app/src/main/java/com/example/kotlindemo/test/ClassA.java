package com.example.kotlindemo.test;

/**
 * Created on 4/10/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */


import java.util.Collections;
import java.util.List;

/**
 *
 *
 *
 * 通过访问权限控制，隐藏内部数据，外部仅能通过类暴露的接口
 *
 * 来访问   这是封装的含义
 *
 *
 */
public class ClassA {

    private String name;

    private int age;

    private List<String> items;


    private String getName() {
        return name;
    }

    private ClassA setName(String name) {
        this.name = name;
        return this;
    }

    private int getAge() {
        return age;
    }

    public ClassA setAge(int age) {
        this.age = age;
        return this;
    }

    public List<String> getSomething(){

        /**
         * java 中对该类做出了特殊处理需要  不能对 list的 add
         * clear 做操作
         *
         */
        return  Collections.unmodifiableList(this.items);
    }
}
