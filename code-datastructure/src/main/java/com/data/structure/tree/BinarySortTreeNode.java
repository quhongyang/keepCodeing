package com.data.structure.tree;

import com.data.structure.huffmancode.Node;
import lombok.Data;

import java.nio.file.attribute.UserPrincipalLookupService;

@Data
public class BinarySortTreeNode  {
    int value;
    BinarySortTreeNode left;
    BinarySortTreeNode right;

    public BinarySortTreeNode(int value) {
        this.value = value;
    }


    /**
     * 向子树中添加节点
     * @param node
     */
    public void add(BinarySortTreeNode node) {
        if(node == null){
            return;
        }
        //判断传入节点的值比当前子树的根节点的值大还是小
        if(node.value<this.value){
            //如果左节点为空
            if(this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if(this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    public void frontShow(BinarySortTreeNode node) {
        if(node == null){
            return;
        }
        node.frontShow(node.left);
        System.out.println(node.value);
        node.frontShow(node.right);

    }

    /**
     * 查找节点
     * @param value
     */
    public BinarySortTreeNode search(int value) {
        if(this.value == value){
            return this;
        }else if(value<this.value){
            if(left ==null){
                return null;
            }
            return left.search(value);
        }else {
            if(right == null){
                return null;
            }
            return right.search(value);

        }    }
}
