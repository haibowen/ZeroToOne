package com.example.kotlindemo.utils;


import android.app.usage.UsageStats;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型学习
 */
public class GenericTest {


    public static void main(String[] args) {
        List<String> name=new ArrayList<>();
        List<Integer> age=new ArrayList<>();
        List<Number> numbers=new ArrayList<>();

        name.add("icon");
        age.add(20);
        numbers.add(30);

        getData(name);
        getData(age);
        getData(numbers);

        getUpNumber(age);
        getUpNumber(numbers);

    }

    public static void getData(List<?> data){
        System.out.println("data"+data.get(0));

    }

    public static void getUpNumber(List<?extends Number> data){

        System.out.println(data.get(0));


    }
}
