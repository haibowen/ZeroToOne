package com.example.java_test.structure;

/**
 * Created on 4/29/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */

/**
 * 可以用数组来实现
 *
 * 遍历的时候  倒叙输出
 */
public class StackDemo {


    private int size; //定义栈的大小
    private int[] stack;//数组模拟栈
    private int top = -1;//表示栈顶部

    /**
     * 构造
     *
     * @param size
     */
    public StackDemo(int size) {
        this.size = size;
        stack = new int[this.size];
    }

    /**
     * 栈满
     */

    public boolean isFull() {
        return top == size - 1;

    }

    /**
     * 栈空
     */
    public boolean isEmpty() {
        return top == -1;

    }

    /**
     * 入栈 push
     */
    public void push(int value) {

        //先判断栈是否满
        if (isFull()) {
            return;
        }
        top++;
        stack[top] = value;

    }

    /**
     * 出栈 pop 将栈定的数据返回
     */
    public int pop() {
        if (isEmpty()) {
            //栈空没有数据
            throw new RuntimeException("栈空，没有数据");

        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈

    public void list() {
        if (isEmpty()) return;
        for (int i = top; i > 0; i--) {
            System.out.println(stack[i] + "");

        }
    }

}
