package com.example.kotlindemo.utils;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

/**
 * Created on 4/18/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */


/**
 * 集合中的set 是无序且不可以重复的
 */
public class Conllections {


    public static void main(String[] args) {


        Set<String> set = new HashSet<String>();

        for (int i = 0; i < 10; i++) {
            set.add("hello world");
            set.add("hello world");
            set.add("tst");
            set.add("test");
            set.add(null);

        }
        System.out.println("集合中的元素个数" + set.size());
        System.out.println("集合中的元素" + set.toString());

        System.out.println("=========================");
        setLinkedHashSet();
        System.out.println("=========================");
        setTreeSet();
        System.out.println("=========================");
        setArrayList();
        System.out.println("=========================");
        setVector();



    }


    /**
     * linkedhashset 是hashset的子类
     */

    public static void setLinkedHashSet() {

        Set<String> linkedSet = new LinkedHashSet<>();

        for (int i = 0; i < 10; i++) {
            linkedSet.add("test");
            linkedSet.add("hello");
            linkedSet.add("world");
            linkedSet.add("world");

        }

        System.out.println("集合中的元素" + linkedSet.toString());
        System.out.println("集合中的元素个数" + linkedSet.size());
    }

    /**
     * 有序的set  排好序
     * <p>
     * treeset
     */

    public static void setTreeSet() {

        Set<Integer> numberSet = new TreeSet<>();
        numberSet.add(2);
        numberSet.add(12);
        numberSet.add(22);
        numberSet.add(112);
        numberSet.add(20);
        numberSet.add(32);
        numberSet.add(29);
        System.out.println(numberSet.toString());
    }

    /**
     * enmuset 枚举类型的  set
     * 也是有序的 按照加入的顺序
     */

    public static void setEnumSet(){



    }

    /**
     * list的相关使用  arrayList 的创建
     *
     * 底层实现是  数组
     * array
     * 随机访问的效率较高
     */

    public static void setArrayList(){

        List<String> dataList=new ArrayList<>();
        System.out.println(dataList.size());

    }

    /**
     *  list 的相关使用，linkedList 的创建
     *
     *  底层的实现是  链表  link
     *
     *  插入删除的效率较高
     */

    public  static  void  setLinkedList(){
        List<String> listShow=new LinkedList<>();


    }

    /**
     * vector的设置
     *
     *
     */

    public static  void setVector(){
        List<String> vectorList=new Vector<>() ;
        vectorList.add("2");
        vectorList.add("1");
        vectorList.add("23");
        vectorList.add("12");

        Iterator<String> iterator=vectorList.iterator();
        //输出所有集合
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
