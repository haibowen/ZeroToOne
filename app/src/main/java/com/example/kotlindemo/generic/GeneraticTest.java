package com.example.kotlindemo.generic;

/**
 * Created on 4/4/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public class GeneraticTest  implements GeneraticInterface<String>{

    public static void main(String[] args) {

        Generatic<String> stringGeneratic=new Generatic<>("测试使用String");

        Generatic<Integer> integerGeneratic=new Generatic<>(222);

        Generatic<Boolean> booleanGeneratic=new Generatic<>(true);

        booleanGeneratic.test(123);

        System.out.println(stringGeneratic.name);
        System.out.println(integerGeneratic.getName());
        System.out.println(booleanGeneratic.getName());


    }

    @Override
    public String produce() {
        return null;
    }
}
