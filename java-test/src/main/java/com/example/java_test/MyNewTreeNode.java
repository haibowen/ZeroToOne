package com.example.java_test;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的使用
 *
 */
public class MyNewTreeNode {

    /**
     * 二叉树的结点定义
     */
    public class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode  right=null;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
        }
    }
    /**
     * 前序遍历
     */
    void preOrder(TreeNode root, List<Integer> ans){
        //边界处理 如果  为空 那么 不需要处理
        if (root!=null){
            //先访问根节点
            ans.add(root.val);
            //再分别 访问左子树
            preOrder(root.left,ans);
            //再访问右子树
            preOrder(root.right,ans);
        }
    }

    /**
     * 使用栈来完成 前序遍历
     */
    public List<Integer> preOrderTraversal(TreeNode root){
        //用来进行递归的栈
        Stack<TreeNode> stack=new Stack<>();
        //用来存放遍历的结果，不算在空间复杂度里面
        List<Integer> ans=new ArrayList<>();
        //开始利用栈来进行遍历
        while (root!=null||!stack.empty()){
            //模拟递归的压栈过程
            while (root!=null){
                stack.push(root);
                ans.add(root.val);
                root=root.left;
            }
            //当无法压栈的 时候  ，将root.right进行压栈
            root= stack.peek();
            stack.pop();
            root=root.right;
        }
        return ans;
    }

    /**
     * 判断一棵树 是不是是  二叉 搜索树
     */

    private boolean ans =true;
    private void  preOrder(TreeNode root,Long l,Long r){
        //1、如果为空树
        //2、如果已经有节点不满足 BST的要求
        if (root==null||!ans){
            return;
        }
        //检查当前 结点是不是 在影子二叉树的区间里面
        //这里相当于在检查两颗二叉树相同 位置的结点
        if (!(l<root.val&&root.val<r)){
            ans=false;
            return;
        }
        //这里同时遍历左子树 （1，root.val）就是 影子二叉树的左子节点
        preOrder(root.left,l,Long.valueOf(root.val));
        //这里同时遍历右子树，（root.val,r）就是影子二叉树的右子节点
        preOrder(root.right,Long.valueOf(root.val),r);

    }
    public boolean isValidBST(TreeNode root){
        ans=true;
        preOrder(root,Long.MIN_VALUE,Long.MAX_VALUE);
        return ans;
    }

    /**
     * 目标和所有 路径
     */

    private  List<List<Integer>> ansDemo=new ArrayList<>();
    private void  backtrace(TreeNode root,List<Integer> path,int sum,int target){
        //如果已经是 空树 那么没有必要看
        if (root==null){
            return;
        }
        //前序遍历   加上累计的和
        sum+=root.val;
        //将节点 添加到路径中 ，相当于压栈一样
        path.add(root.val);
        if (root.left==null&&root.right==null){
            if (sum==target){
                ansDemo.add(new ArrayList<>(path));
            }

        }else {
            //回溯 分别再看子情况
            backtrace(root.left,path,sum,target);
            backtrace(root.right,path,sum,target);

        }
        path.remove(path.size()-1);

    }

    public List <List<Integer>> pathSum(TreeNode root,int sum){
        //路径
        List<Integer> path=new ArrayList<>();
        backtrace(root,path,0,sum);
        return ansDemo;
    }

    /**
     * 中序遍历
     */

    void   preOrderMiddle(TreeNode root,List<Integer> ans){
        if (root!=null){
            //先 遍历左子树
            preOrderMiddle(root.left,ans);
            //然后遍历中间 的根节点
            ans.add(root.val);
            //最后遍历右子树
            preOrderMiddle(root.right,ans);
        }
    }

    /**
     * 使用栈  实现中序遍历
     */

    public List<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        while (root!=null||!stack.empty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            //到达了最左边，把节点弹出来，进行遍历
            root=stack.peek();
            stack.pop();
            ans.add(root.val);
            //转向右子树
            root=root.right;
        }
        return ans;
    }

    /**
     * 后续遍历  递归方式
     */
    void postOrder(TreeNode root,List<Integer> ans){
        if (root!=null){
            //先遍历 左子树
            postOrder(root.left,ans);
            //最后遍历右子树
            postOrder(root.right,ans);
            //遍历中间的根节点
            ans.add(root.val);
        }
    }
}
