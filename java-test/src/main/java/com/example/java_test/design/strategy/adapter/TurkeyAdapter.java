package com.example.java_test.design.strategy.adapter;


/**
 * 对接口做一个包装
 */
public class TurkeyAdapter implements Duck {

    Turkey turkey;
    //持有接口
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;

    }

    @Override
    public void quack() {
        turkey.gobble();

    }

    @Override
    public void fly() {

        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
