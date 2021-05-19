package com.example.java_test.design;

public class Quack implements QuackBehavior {
    @Override
    public void quick() {
        System.out.println("我是Quack");
    }
}
