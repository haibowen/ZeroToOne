package com.example.java_test.design.strategy.factory;


/**
 * 测试
 */
public class Test {
    public static void main(String[] args) {
        PizzaStore pizzaStore=new NYPizzaStore();
        Pizza pizza=pizzaStore.orderPizza("cheese");
        System.out.println(pizza.getName()+"...."+"测试");
    }
}
