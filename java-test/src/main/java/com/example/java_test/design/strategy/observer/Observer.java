package com.example.java_test.design.strategy.observer;


/**
 * 所有观察者都需要实现 的接口
 */
public interface Observer {

    public void update(float temp, float humidity, float pressure);

}
