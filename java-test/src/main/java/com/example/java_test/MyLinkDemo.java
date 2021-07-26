package com.example.java_test;


/**
 * 链表的实现
 */
public class MyLinkDemo {

    Node head = null;//头结点
    /**
     * 定义一个节点
     */
    class Node {
        Node next = null;//节点的 引用 指向下一个节点
        int data;//节点对象  内容

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 向链表中插入数据
     */

    public void addNode(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    /**
     * 删除第  index个节点
     */

    public boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 1;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

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

    /**
     * 在不知道头指针 的 情况下 删除指定节点
     */

    public boolean deleteNode(Node n) {
        if (n == null || n.next == null) return false;
        int tmp = n.data;
        n.data = n.next.data;
        n.next.data = tmp;
        n.next = n.next.next;
        return true;
    }

    /**
     * 输出操作
     */
    public void printList() {
        MyLinkDemo myLinkDemo = new MyLinkDemo();
        myLinkDemo.addNode(1);
        myLinkDemo.addNode(3);
        myLinkDemo.addNode(2);
        myLinkDemo.addNode(9);
    }

    /**
     * 链表反转
     */

    public Node ReverseIteratively(Node head) {
        Node pReversedHead = head;
        Node pNode = head;
        Node pPrev = null;
        while (pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null) {
                pReversedHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        this.head = pReversedHead;
        return this.head;
    }
}
