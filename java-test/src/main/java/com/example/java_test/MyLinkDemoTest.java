package com.example.java_test;


/**
 * 链表测试
 */
public class MyLinkDemoTest {

    Node head = null;

    class Node {
        Node next = null;// 节点的指向下一个节点
        int data;//节点对象 内容

        //构建节点
        Node(int data) {
            this.data = data;
        }
    }

    /**
     * 链表中插入数据  尾部 插入
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
     * 插入节点
     */

    public void addNodeTest(int d) {
        Node node = new Node(d);
        if (head == null) {
            head = node;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    /**
     * 删除指定节点 不知道头指针
     */
    public boolean deleteNode(Node node) {
        if (node == null || node.next == null) return false;
        int tmp = node.data;
        node.data = node.next.data;
        node.next.data = tmp;
        node.next = node.next.next;
        return true;
    }

    /**
     * 删除第 index个节点
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
     * 删除第index个节点的测试
     */

    public boolean deleteNodeTest(int index) {
        if (index < 1 || index > length()) return false;
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
     * 链表长度
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
     * 返回 一个 链表的长度
     */

    public int lengthTest() {
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    /**
     * 链表反转的测试
     */

    public Node reverseIteratively(Node head) {
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

    /**
     * 链表测试反转demo
     */

    public Node reverseIterativelyDemo(Node head) {

        Node preReverseHead = head;
        Node pNode = head;
        Node pPrev = null;
        while (pNode != null) {
            Node pNext=pNode.next;
            if (pNext==null){
                preReverseHead=pNode;
            }
            pNode.next=pPrev;
            pPrev=pNode;
            pNode=pNext;
        }
        this.head=preReverseHead;
        return this.head;
    }

    /**
     * 链表测试反转
     */

    public static  Node Reverse(Node  head){
        if (head==null||head.next==null)return head;
        Node reHead=Reverse(head.next);//先反转 后续结点
       head= head.next.next;
       head.next=null;
       return reHead;
    }

    /**
     * 链表表反转
     */
    public Node reverseIterativelyTest(Node head){
        Node pReversedHead=head;
        Node  pNode=head;
        Node  pPrev=null;
        while (pNode!=null){
            Node  pNext=pNode.next;
            if (pNext==null){
                pReversedHead=pNode;
            }

            pNode.next=pPrev;
            pPrev=pNode;
            pNode=pNext;

        }
        this.head=pReversedHead;
        return this.head;

    }


    /**
     * 反转 测试
     */
    public static void main(String[] args) {
        MyLinkDemoTest  myLinkDemoTest=new MyLinkDemoTest();
        myLinkDemoTest.addNode(1);
        myLinkDemoTest.addNode(2);
        myLinkDemoTest.addNode(3);
        printlnList(myLinkDemoTest.head);
        printlnList(myLinkDemoTest.reverseIterativelyDemo(myLinkDemoTest.head));

    }

    /**
     * 遍历链表
     */
    public  static  void  printlnList(Node head){
        if (head!=null){
            printlnList(head.next);
            System.out.println("链表的值为:"+head.data);
        }
    }
}
