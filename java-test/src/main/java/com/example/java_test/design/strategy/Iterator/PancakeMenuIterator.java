package com.example.java_test.design.strategy.Iterator;


import java.util.ArrayList;

/**
 * 实现公共的 遍历接口
 */
public class PancakeMenuIterator   implements Iterator{


    ArrayList<MenuItem> menuItemArrayList;
    int position=0;

    public PancakeMenuIterator(ArrayList<MenuItem> menuItemArrayList) {
        this.menuItemArrayList = menuItemArrayList;
    }

    @Override
    public boolean hasNext() {

        if (position>menuItemArrayList.size()-1){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Object next() {

        MenuItem menuItem=menuItemArrayList.get(position);
        position+=1;
        return menuItem;
    }
}
