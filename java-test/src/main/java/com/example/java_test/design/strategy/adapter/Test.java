package com.example.java_test.design.strategy.adapter;


/**
 * 测试 适配器模式
 */
public class Test {

    public static void main(String[] args) {

        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.fly();
        mallardDuck.quack();

        //适配器 模式 为了跟duck 具有相同的行为
        ReallyTurkey reallyTurkey = new ReallyTurkey();
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(reallyTurkey);
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}
