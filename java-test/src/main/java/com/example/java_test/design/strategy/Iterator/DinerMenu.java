package com.example.java_test.design.strategy.Iterator;


/**
 * 具体 菜单项 采用数组来存储具体的 每一项
 */
public class DinerMenu {

    static final int MAX_ITEMS = 6;
    int numberOffItems = 0;
    MenuItem[] menuItems;


    /**
     * 构造方法
     *
     * @param
     * @param
     */
    public DinerMenu() {

        menuItems = new MenuItem[MAX_ITEMS];
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem  menuItem=new MenuItem(name,description,vegetarian,price);
        if (numberOffItems>=MAX_ITEMS){
            System.out.println("can not  add  item");
        }else {
            menuItems[numberOffItems]=menuItem;
            numberOffItems+=1;
        }

    }

    public Iterator createIterator(){

        return  new DinerMenuIterator(menuItems);
    }
}
