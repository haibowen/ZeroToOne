package com.example.java_test.design.strategy.factory;

public class NYPizzaStore  extends PizzaStore{

    @Override
    protected Pizza createPizza(String type) {

        Pizza pizza=null;
        PizzaIngredientFactory pizzaIngredientFactory=new NYPizzaIngredientFactory();

        if (type.equals("cheese")){
            pizza=new CheesePizza(pizzaIngredientFactory);
            pizza.setName("");
        }
        return pizza;
    }
}
