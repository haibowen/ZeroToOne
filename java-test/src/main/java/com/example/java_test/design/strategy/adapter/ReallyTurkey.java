package com.example.java_test.design.strategy.adapter;


/**
 * 火鸡接口的特定实现
 */
public class ReallyTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble");
    }

    @Override
    public void fly() {
        System.out.println("I  am  flying  short    distance");

    }
}
