package com.example.java_test.design.strategy.factory;

public class ClamPizza extends Pizza {

    PizzaIngredientFactory pizzaIngredientFactory;

    public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;

    }

    @Override
    void prepare() {
        System.out.println("preparing" + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        chess = pizzaIngredientFactory.createChess();

    }
}
