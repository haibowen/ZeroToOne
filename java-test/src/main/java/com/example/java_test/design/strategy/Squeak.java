package com.example.java_test.design;

public class Squeak implements QuackBehavior {
    @Override
    public void quick() {
        System.out.println("我们是Squeak");
    }
}