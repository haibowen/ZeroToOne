package com.example.java_test.design.strategy.decorator;

/**
 * 具体的饮料
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
