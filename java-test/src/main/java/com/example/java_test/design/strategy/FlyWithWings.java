package com.example.java_test.design.strategy;

public class FlyWithWings implements FlyBehavior {


    @Override
    public void fly() {
        System.out.println("我正在飞行");
    }
}
