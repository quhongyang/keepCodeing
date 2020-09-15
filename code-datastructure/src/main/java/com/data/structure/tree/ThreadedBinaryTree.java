package com.data.structure.tree;

/**
 * 顺序存储的二叉树通常情况只考虑完全二叉树
 * 第n个元素的左子节点是：2*n+1
 * 第n个元素的右子节点是：2*n+2
 * 第n个元素的父节点：(N-1)/2
 */
public class ThreadedBinaryTree {
    ThreadedNode root;
    //用于临时存储前驱节点
    ThreadedNode pre = null;

    public void setRoot(ThreadedNode root) {
        this.root = root;
    }

    //中序线索化二叉树
    public void threadNodes(){
        threadNodes(root);
    }
    public void threadNodes(ThreadedNode node){
        //当前节点如果为null,直接返回
        if (node == null) {
            return;
        }
        //处理左子树
        threadNodes(node.leftNode);
        if(node.leftNode == null){
            //让当前节点大的左指针指向前驱节点
            node.leftNode = pre;
            //改变当前节点左指针类型
            node.leftType = 1;
        }
        //处理前驱的右指针，如果前驱节点的右指针是null(没有指向右子树)
        if(pre!= null && pre.rightNode == null){
            //让前驱节点的右指针指向当前节点
            pre.rightNode = node;
            //改变前驱节点的右指针类型
            pre.rightType = 1;

        }
        //每处理一个节点，当前节点是下一个节点的前驱节点
        pre = node;
        //处理右子树
        threadNodes(node.rightNode);
    }

    public ThreadedNode ThreadedNode() {
        return root;
    }
    public void frontShow(){
        if(root != null){
            root.frontShow();
        }
    }

    public ThreadedNode frontSearch(int i) {
        return root.frontSearch(i);
    }

    public void delete(int i) {
        if(root.value == i){
            root = null;
        }else {
            root.delete(i);
        }
    }
}
