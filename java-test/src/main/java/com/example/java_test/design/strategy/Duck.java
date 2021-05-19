package com.example.java_test.design;


/**
 * 设计模式的基本原则   (1)分开变化的和不变化的
 * （2）针对接口编程
 * （3）多用组合少用继承
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    //外观方法  子类实现
    abstract void display();

    //委托给行为类
    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quick();
    }
    public void swim(){
        System.out.println("这是一个测试游泳的方法");
    }


}



