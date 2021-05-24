package com.example.java_test.design.strategy.Iterator;

public class Test {

    public static void main(String[] args) {
        DinerMenu dinerMenu=new DinerMenu();
        dinerMenu.addItem("test","hyplo",true,20.0);

        PancakeMenu pancakeMenu=new PancakeMenu();
        pancakeMenu.addItem("hyplo","android",false,30);

        Waitress waitress=new Waitress(dinerMenu,pancakeMenu);
        waitress.printMenu();
    }
}
