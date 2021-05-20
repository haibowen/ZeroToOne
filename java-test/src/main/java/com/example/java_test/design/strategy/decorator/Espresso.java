package com.example.java_test.design.strategy.decorator;


/**
 * 具体的 饮料
 */
public class Espresso extends Beverage {


    public  Espresso(){
        description="Espresso";
    }

    /**
     * 价格
     * @return
     */
    @Override
    public double cost() {
        return 1.0;


    }


}
