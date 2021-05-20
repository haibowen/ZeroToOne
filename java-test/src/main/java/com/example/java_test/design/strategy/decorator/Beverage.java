package com.example.java_test.design.strategy.decorator;


/**
 * 装饰者模式
 */

/**
 * 饮料的基类
 */
public abstract class Beverage {
    String description = "Unknown Beverage ";

    public String getDescription() {
        return description;
    }

    public abstract double cost();


}
