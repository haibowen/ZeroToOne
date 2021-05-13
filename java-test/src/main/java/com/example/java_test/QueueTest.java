package com.example.java_test;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueTest {

    public List<List<Integer>> levelOrder(TreeNode node) {
        //生成 FiFo队列
        Queue<TreeNode> queue = new LinkedList<>();
        //若果节点不为空加入 FIFO队列
        if (node != null) {
            queue.offer(node);
        }
        //保存层次遍历的结果
        List<List<Integer>> ans = new LinkedList<>();
        //开始利用FIFO队列进行层次遍历
        while (queue.size() > 0) {
            //取出当前层里面的个数
            final int qSize = queue.size();
            //当前层的结果存放于temp链表中
            List<Integer> tmp = new LinkedList<>();
            //遍历当前层的每个节点
            for (int i = 0; i < queue.size(); i++) {
                //当前层前面的节点先出队
                TreeNode cur = queue.poll();
                //结果存放与当前队列中
                tmp.add(cur.val);
                //下一层的节点 入队
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}
