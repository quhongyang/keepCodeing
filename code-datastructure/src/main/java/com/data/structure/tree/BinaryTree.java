package com.data.structure.tree;

/**
 * 顺序存储的二叉树通常情况只考虑完全二叉树
 * 第n个元素的左子节点是：2*n+1
 * 第n个元素的右子节点是：2*n+2
 * 第n个元素的父节点：(N-1)/2
 */
public class BinaryTree {
    TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }
    public void frontShow(){
        if(root != null){
            root.frontShow();
        }
    }

    public TreeNode frontSearch(int i) {
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
