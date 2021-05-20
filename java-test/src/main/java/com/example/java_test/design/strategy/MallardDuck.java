package com.example.java_test.design.strategy;

public class MallardDuck extends Duck {


    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("我是 真实的 mallard duck");
    }
}
