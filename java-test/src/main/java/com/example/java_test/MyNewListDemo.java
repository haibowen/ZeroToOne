package com.example.java_test;


/**
 * 链表操作
 */

/**
 * 针对链表有 一些特殊的操作，对链表的后续操作有很大的帮助 ，     ----------假头
 * <p>
 * <p>
 * 链表的一些基本 操作
 * <p>
 * 初始化
 * <p>
 * 追加结点
 * <p>
 * <p>
 * 头部插入结点
 * <p>
 * <p>
 * 查找结点
 * <p>
 * 插入指定 位置的结点
 * <p>
 * <p>
 * 删除结点
 */
public class MyNewListDemo {

    /**
     * 链表中结点的定义
     */

    class ListNode {
        public int var = 0;//数据
        public ListNode next = null;//结点

        public ListNode() {

        }

        public ListNode(int x) {
            var = x;
        }
    }

    //头结点
    private ListNode dummy = new ListNode();
    //尾结点
    private ListNode tail = dummy;
    //链表长度
    private int length = 0;

    /**
     * 初始化链表
     */
    public MyNewListDemo() {

    }

    /**
     * 将值 为val 的结点追加到 链表 尾部
     */
    public void addAtTail(int val) {

        /**
         * 将值为 val的结点追加到链表尾部
         * 尾部 添加一个新结点
         */
        tail.next = new ListNode(val);
        /**
         * 移动tail指针
         *
         */
        tail = tail.next;
        /**
         * 链表长度+1
         */
        length++;

    }

    /**
     * 头插一个节点
     */
    public void addAtHead(int val) {

        /**
         * 插入值val 的 新结点,使他成为 链表的第一个结点
         */
        ListNode p = new ListNode(val);
        /**
         * 将p.next指向新结点,使之成为第一个结点
         */
        dummy.next = p;
        /**
         * 注意动静结合原则，添加结点时,注意修改tail指针
         */
        if (tail == dummy) {
            tail = p;
        }
        length++;
    }


    /**
     * 获取一个  getPrevNode 函数
     * <p>
     * 返回 的是 目标 结点的前一个 结点
     */

    public ListNode getPrevNode(int index) {
        /**
         * 返回index 结点的前驱结点 若果 index不存在，那么返回dummy
         *
         * 初始化 front  与back 分别 一前一后
         */
        ListNode front = dummy.next;
        ListNode back = dummy;

        /**
         * 在查找的时候 front 与back总是一起走
         */
        for (int i = 0; i < index && front != null; i++) {
            back = front;
            front = front.next;
        }
        return back;
    }


    /**
     * 获取一个节点
     */
    public int get(int index) {

        /**
         * 获取链表中地index个节点的值。若果索引无效,则返回  -1
         */
        if (index < 0 || index >= length) {
            return -1;
        }
        return getPrevNode(index).next.var;

    }

    /**
     * 插入到 指定位置 之前
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {

        if (index > length) {
            /**
             * index 大于链表长度   则不会插入结点
             */
            return;
        } else if (index == length) {
            /**
             * index 等于链表的长度，则将节点 附加到链表的末尾
             */
            addAtTail(val);

        } else if (index <= 0) {
            addAtHead(val);
        } else {
            ListNode pre = getPrevNode(index);

            //在 pre 后面添加新结点
            ListNode p = new ListNode(val);
            p.next = pre.next;
            pre.next = p;

            length++;
        }


    }

    public void deleteAtIndex(int index) {

    }
}
