package com.example.java_test.design.strategy;

public class FlyWithNo implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我不能飞行");
    }
}
