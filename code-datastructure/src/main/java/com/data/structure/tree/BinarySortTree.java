package com.data.structure.tree;

import com.data.structure.huffmancode.Node;

public class BinarySortTree {
    BinarySortTreeNode root;

    /**
     * 向二叉排序树中添加节点
     * @param node
     */
    public void add(BinarySortTreeNode node){
        //如果是一颗空树
        if(root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    /**
     * 中序遍历二叉排序树，从小到大的顺序
     */
    public void frontShow(){
        if(root != null){
            root.frontShow(root);
        }
    }

    /**
     * 节点的查找
     * @param value
     * @return
     */
    public BinarySortTreeNode search(int value){
        if(root == null){
            return null;
        }else {
           return root.search(value);
        }
    }
}
