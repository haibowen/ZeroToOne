package com.example.java_test.structure;

import androidx.annotation.NonNull;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TreeNode<T> implements Iterable<TreeNode<T>> {


    /**
     * 树节点
     * @return
     */

    public T data;

    /**
     * 根  没有父节点
     * @return
     */

    public TreeNode<T> parent;

    /**
     * 子节点
     * 叶子节点没有子节点
     * @return
     */
    public List<TreeNode<T>> children;

    /**
     * 保存了当前节点 及其所有子节点,方便查询
     * @return
     */
    private List<TreeNode<T>> elementsIndex;


    /**
     * 构造函数
     * @return
     */

    public TreeNode(T data){
        this.data=data;
        this.children=new LinkedList<TreeNode<T>>();
        this.elementsIndex=new LinkedList<TreeNode<T>>();
        this.elementsIndex.add(this);
    }

    /**
     * 判断是否为根，根没有父节点
     * @return
     */

    public boolean isRoot(){
        return parent==null;
    }

    /**
     * 判断是否为子节点  子节点没有 子节点
     * @return
     */

    public boolean isLeaf(){
        return children.size()==0;
    }

    /**
     * 添加一个子节点
     * @return
     */

    public TreeNode<T> addChild(T child){
        TreeNode<T> childNode=new TreeNode<T>(child);
        childNode.parent=this;
        this.children.add(childNode);
        this.registerChildForSearch(childNode);
        return childNode;
    }

    /**
     * 获取当前节点的层
     */

    public   int getLevel(){
        if (this.isRoot()){
            return 0;
        }else {
            return parent.getLevel()+1;
        }

    }
    /**
     * 递归为当前节点以及当前节点的所有父节点增加新的节点
     *
     * @param
     */

    private void registerChildForSearch(TreeNode<T> node){
        elementsIndex.add(node);
        if (parent!=null){
            parent.registerChildForSearch(node);
        }


    }

    /**
     *
     *
     * @return
     */
    @NonNull
    @Override
    public Iterator<TreeNode<T>> iterator() {
        return null;
    }

    @Override
    public void forEach(@NonNull Consumer<? super TreeNode<T>> action) {

    }

    @NonNull
    @Override
    public Spliterator<TreeNode<T>> spliterator() {
        return null;
    }
}
