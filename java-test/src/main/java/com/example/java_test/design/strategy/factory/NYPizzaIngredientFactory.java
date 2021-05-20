package com.example.java_test.design.strategy.factory;


/**
 * 工厂的实现类
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory{

    @Override
    public Dough createDough() {
        return new Dough();
    }

    @Override
    public Sauce createSauce() {
        return new Sauce();
    }

    @Override
    public Chess createChess() {
        return new Chess();
    }
}
