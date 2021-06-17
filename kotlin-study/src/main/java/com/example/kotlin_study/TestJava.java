package com.example.kotlin_study;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2021/6/12
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public class TestJava {

    public static void main(String[] args) {



    }

    void test(){
        // ？ extends list 集合只能获取 不能修改
        List<? extends Person> listDemo=new ArrayList<Student>();
        //不能修改
//        listDemo.add(new Person());
//        listDemo.add(new Student());
//
        //能获取
        Person person=listDemo.get(0);
    }

    void test2(){
        //？ super list 集合 不能获取 可以修改
        List<? super Student> list=new ArrayList<Person>();
        //
        list.add(new Student());
        //
//        Student student=list.get(0);
    }


    void show(List<? extends Person> list){

        for (Person person:list){
            //list.add(person)

        }
    }

    void  test3(){
        List<Student> list=new ArrayList<>();
        show(list);
    }
}
