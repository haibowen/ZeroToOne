package com.example.java_test.design.strategy.factory;


/**
 * 具体要制作的pizza
 */
public class CheesePizza extends Pizza {

    PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;

    }

    @Override
    void prepare() {
        System.out.println("Preparing"+name);
        dough=pizzaIngredientFactory.createDough();
        sauce=pizzaIngredientFactory.createSauce();
        chess=pizzaIngredientFactory.createChess();

    }
}
