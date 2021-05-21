package com.example.java_test.design.strategy.adapter;


/**
 * 绿头鸭的实现
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quacking");
    }

    @Override
    public void fly() {
        System.out.println("I am  flying");

    }
}
