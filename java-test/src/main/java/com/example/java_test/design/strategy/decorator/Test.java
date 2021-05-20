package com.example.java_test.design.strategy.decorator;


/**
 *
 * 装饰者的过渡使用 会导致程序中存在许多小对象
 * 程序变得 复杂
 */
public class Test {

    public static void main(String[] args) {

        Beverage beverage = new Espresso();
        //不需要调料 打印他的价钱和描述
        System.out.println(beverage.getDescription() + "...." + beverage.cost());

        //装饰者模式
        Beverage  beverage1=new HouseBlend();
        beverage1=new Mocha(beverage1);
        System.out.println(beverage1.getDescription()+"...."+beverage1.cost());
    }
}
