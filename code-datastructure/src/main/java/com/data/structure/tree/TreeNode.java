package com.data.structure.tree;

public class TreeNode {
    //节点的权
    int value;
    //左儿子
    TreeNode leftNode;
    //右儿子
    TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    //前序遍历
    public void frontShow() {
        System.out.println(value);
        //左节点
        if (leftNode != null) {
            leftNode.frontShow();
        }
        if (rightNode != null) {
            rightNode.frontShow();
        }

    }

    public TreeNode frontSearch(int i) {
        TreeNode target = null;
        //对比当前节点的值
        if (this.value == i) {
            return this;
            //当前节点的值不是要查找的节点
        } else {
            //查找左儿子
            if (leftNode != null) {
                leftNode.frontSearch(i);
                //有可能查到，也可以查不到，查不到的话，target还是一个null
                target = leftNode.frontSearch(i);
            }
            //如果不为空，说明左儿子已经找到
            if (target != null) {
                return target;
            }
            //查找右儿子
            if (rightNode != null) {
                target = rightNode.frontSearch(i);
            }
        }
        return target;
    }

    //删除一个子树
    public void delete(int i) {
        TreeNode parent = this;
        //判断左儿子
        if (parent.leftNode != null && parent.leftNode.value == i) {
            parent.leftNode = null;
            return;
        }
        //判断右儿子
        if (parent.rightNode != null && parent.rightNode.value == i) {
            parent.rightNode = null;
            return;
        }
        //递归检查并删除左儿子
        parent = leftNode;
        if (parent != null) {
            parent.delete(i);
        }
        //递归检查并删除右儿子
        parent = rightNode;
        if (parent != null) {
            parent.delete(i);
        }

    }
}
