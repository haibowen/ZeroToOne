package com.example.kotlindemo.generic;

/**
 * Created on 4/4/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 *
 *
 * 泛型的定义  和使用
 */
public class Generatic<T> {

    public T name;

    public Generatic(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public Generatic<T> setName(T name) {
        this.name = name;
        return this;
    }

    /**
     * 泛型方法
     * @return
     */

    public <E> void test(E e){

    }

    @Override
    public String toString() {
        return "Generatic{" +
                "name=" + name +
                '}';
    }
}
