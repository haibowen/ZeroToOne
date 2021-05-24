package com.example.java_test.design.strategy.Iterator;


/**
 * 实现遍历的接口
 */
public class DinerMenuIterator implements Iterator {

    MenuItem[] items;
    int position = 0;

    public DinerMenuIterator(MenuItem[] menuItems) {
        this.items = menuItems;

    }

    @Override
    public boolean hasNext() {

        if (position > items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {

        MenuItem menuItem = items[position];
        position += 1;
        return menuItem;
    }
}
