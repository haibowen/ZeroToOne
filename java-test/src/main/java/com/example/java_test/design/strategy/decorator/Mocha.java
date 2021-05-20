package com.example.java_test.design.strategy.decorator;


/**
 * 调料的具体实现
 */
public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;

    }

    @Override
    public String getDescription() {
        return beverage.description + "...." + "Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + .20;
    }
}
