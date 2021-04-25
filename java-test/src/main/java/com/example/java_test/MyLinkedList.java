package com.example.java_test;

/**
 * Created on 4/25/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */

/**
 * 自定义链表的创建
 */
public class MyLinkedList {

    Node head = null;


    class Node {
        Node next = null;//节点的引用指向下一个节点
        int data;//节点对象上的数据

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 向链表中插入数据
     */

    public void addData(int data) {
        //实例化一个节点
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        //当前节点不为空的时候
        Node tmp = head;
        if (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    /**
     *删除第  index个节点
     */

//    public boolean deleteNode(int index){
//        if (index< 1|| index>)
//
//    }

    /**
     * 返回节点长度
     */

    public int length() {
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }
}
