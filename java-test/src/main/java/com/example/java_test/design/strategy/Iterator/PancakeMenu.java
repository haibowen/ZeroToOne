package com.example.java_test.design.strategy.Iterator;


import java.util.ArrayList;

/**
 * 另一个 使用list存储的 菜单项
 */
public class PancakeMenu {
    ArrayList <MenuItem> menuItems;

    public PancakeMenu() {
        menuItems=new ArrayList<>();
    }


    public void addItem(String name ,String description,boolean vegetarian,double  price){
        MenuItem menuItem=new MenuItem(name,description,vegetarian,price);
        menuItems.add(menuItem);

    }

    public Iterator  createIterator(){
        return new  PancakeMenuIterator(menuItems);
    }
}
