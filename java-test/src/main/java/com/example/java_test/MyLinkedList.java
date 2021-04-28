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
    static Node head = null;

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addData(1);
        myLinkedList.addData(2);
        myLinkedList.addData(2);
        myLinkedList.addData(3);
        myLinkedList.addData(3);
        myLinkedList.addData(4);
        myLinkedList.addData(5);
        System.out.println("这是 测试" + myLinkedList.toString());
        System.out.println("链表的长度" + myLinkedList.length());
        Node node1 = myLinkedList.removeNode(myLinkedList.head, myLinkedList.length());
        print(node1);
    }

    static class Node {
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
        Node preNode = head;// 前一个 节点
        Node curNode = preNode.next; //当前一个节点
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
     * 删除指定节点 不知道头结点
     */
    public boolean deleteNodeUnKnowHead() {
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

    //    public static void deleteNode(Node p)
//    {
//        if(p==null||p.next==null) return;//如果p为空或为单链表中最后一个结点不符合题意，直接返回
//        //后一个节点
//        Node q=p.next;//q为p的后继结点
//        if (q==null)return;
//        if (p.data==q.data){
//            head=q.next;
//        }else {
//
//
//        }
//    }
    public Node removeNode(Node head, int size) {
        if (head == null) {
            throw new RuntimeException("Invalid param");
        }
        if (size == 0) {
            return head.next;
        }
        Node curNode = head; //当前头结点
        Node nextNode = head.next;//下一个节点
        int count = 0;
        while (count != size) {
            if (curNode.data == nextNode.data) {
                curNode = nextNode.next;
                nextNode = curNode.next;
            } else {
                curNode = nextNode;
                nextNode = nextNode.next;
            }
            count++;
        }
        return curNode;
    }

    /**
     * 遍历
     */
    public static void print(Node node) {
        Node cur = node;
        if (node == null) {
            return;
        }
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    /**
     * 链表删除指定节点
     */
    public static Node removeNode(Node head, Node toRemove) {
        if (head == null || toRemove == null) {
            return head;
        }
        //非尾节点
        if (toRemove.next != null) {
            Node toRemoveNext = toRemove.next;
            toRemove.data = toRemoveNext.data;
            toRemove.next = toRemoveNext.next;
            return head;
        } else {
        }
        return null;
    }
}
