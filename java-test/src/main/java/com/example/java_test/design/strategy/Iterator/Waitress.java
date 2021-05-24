package com.example.java_test.design.strategy.Iterator;


/**
 * 服务员的操作
 */
public class Waitress {

    DinerMenu dinerMenu;
    PancakeMenu pancakeMenu;

    public Waitress(DinerMenu dinerMenu,PancakeMenu pancakeMenu){
        this.dinerMenu=dinerMenu;
        this.pancakeMenu=pancakeMenu;
    }

    public void printMenu(){

        Iterator iterator=dinerMenu.createIterator();
        Iterator iterator1=pancakeMenu.createIterator();
        printMenu(iterator1);
        printMenu(iterator);

    }

    public void printMenu(Iterator   iterator){

        while (iterator.hasNext()){
            MenuItem menuItem= (MenuItem) iterator.next();
            System.out.println("开始输出----------------------");
            System.out.println(menuItem.description+menuItem.name+menuItem.price);
            System.out.println("输出结束-----------------------");
        }
    }
}
