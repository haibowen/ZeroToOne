package com.example.java_test.design.strategy.factory;


/**
 * 负责原材料的生产
 */
public interface PizzaIngredientFactory {


    public Dough createDough();
    public Sauce createSauce();
    public Chess createChess();

}
