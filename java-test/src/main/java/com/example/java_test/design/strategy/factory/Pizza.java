package com.example.java_test.design.strategy.factory;


/**
 * pizza的 基类
 */
public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Chess chess;

    abstract void prepare();

    void bake() {
        System.out.println("bake ");
    }

    void cut() {
        System.out.println("cut");
    }

    void box() {
        System.out.println("box");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
