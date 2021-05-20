package com.example.java_test.design.strategy.observer;


/**
 * 定义的 主题 接口
 * <p>
 * 设计到三个方法
 */
public interface Subject {

    public void registerObserver(Observer  observer);

    public void unRegisterObserver(Observer observer);

    public void notifyObservers();


}
