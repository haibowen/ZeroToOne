package com.example.kotlindemo.utils

/**
 * Created on 4/25/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
/**
 * 自定义链表的创建
 */
class MyLinkedList {
    var head: MyLinkedList.Node? = null

    class Node(//节点对象上的数据
            var data: Int) {
        var next: MyLinkedList.Node? = null //节点的引用指向下一个节点

    }

    /**
     * 向链表中插入数据
     */
    fun addData(data: Int) {
        //实例化一个节点
        val node: MyLinkedList.Node = MyLinkedList.Node(data)
        if (head == null) {
            head = node
            return
        }
        //当前节点不为空的时候
        var tmp: MyLinkedList.Node = head as Node
        if (tmp.next != null) {
            tmp = tmp.next!!
        }
        tmp.next = node
    }

    /**
     * 删除第  index个节点
     */
    fun deleteNode(index: Int): Boolean {
        if (index < 1 || index > length()) {
            return false
        }
        if (index == 1) {
            head = head!!.next
            return true
        }
        var i = 1
        var preNode: MyLinkedList.Node? = head // 前一个 节点
        var curNode: Node? = preNode!!.next //当前一个节点
        while (curNode != null) {
            if (i == index) {
                preNode!!.next = curNode.next
                return true
            }
            preNode = curNode
            curNode = curNode.next
            i++
        }
        return false
    }

    /**
     * 删除指定节点 不知道头结点
     */
    fun deleteNodeUnKnowHead(): Boolean {
        return false
    }

    /**
     * 返回节点长度
     */
    fun length(): Int {
        var length = 0
        var tmp: MyLinkedList.Node? = head
        while (tmp != null) {
            length++
            tmp = tmp.next
        }
        return length
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
    fun removeNode(head: MyLinkedList.Node?, size: Int): MyLinkedList.Node {
        if (head == null) {
            throw RuntimeException("Invalid param")
        }
        if (size == 0) {
            return head.next!!
        }
        var preNode: Node = head //前一个
        var curNode: Node = head.next!! //后一个
        while (curNode != null) {
            if (preNode.data == curNode.data) {
                preNode = preNode.next!!.next!!
                curNode = preNode.next!!
                break
            }
        }
        return head
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val myLinkedList: MyLinkedList = MyLinkedList()
            myLinkedList.addData(1)
            myLinkedList.addData(2)
            myLinkedList.addData(2)
            myLinkedList.addData(3)
            myLinkedList.addData(3)
            myLinkedList.addData(4)
            myLinkedList.addData(5)
            val node: MyLinkedList.Node = MyLinkedList.Node(1)
            val node1: MyLinkedList.Node = myLinkedList.removeNode(node, myLinkedList.length())
            MyLinkedList.Companion.print(node1)
        }

        /**
         * 遍历
         */
        fun print(node: MyLinkedList.Node?) {
            var cur: MyLinkedList.Node? = node
            if (node == null) {
                return
            }
            while (cur != null) {
                println(cur.data)
                cur = cur.next
            }
        }
    }
}