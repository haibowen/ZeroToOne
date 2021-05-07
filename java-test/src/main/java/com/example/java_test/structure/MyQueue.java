package com.example.java_test.structure;

/**
 * Created on 4/29/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public class MyQueue<E> {
    Node head = null; //队列头
    Node tail = null;//队列尾

    /**
     * 入队操作
     */

    public void put(Integer data) {
        Node newNode = new Node(data);//构造一个新节点
        if (head == null && tail == null) {//队列为空
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    /**
     * 判断队列是否为空
     */

    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 出队操作 若队列为空,则返回null
     * 否则将headj节点指向下一个
     */
    public Integer pop() {
        if (this.isEmpty()) {
            return null;
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    /**
     * 队列的大小
     */

    public int size() {
        int count = 0;
        Node tmp = head;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    /**
     * 设置一个结点
     */
    public class Node {
        Node next = null;
        int data;

        //构造函数
        public Node(int data) {
            this.data = data;
        }
    }
}
