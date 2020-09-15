package com.data.structure;

import com.data.structure.tree.BinaryTree;
import com.data.structure.tree.TreeNode;

public class TreeNodeTest {
    public static void main(String[] args) {
        //创建一颗树
        BinaryTree binaryTree = new BinaryTree();
        //创建一个根节点
        TreeNode root = new TreeNode(1);
        //把根节点赋给树
        binaryTree.setRoot(root);
        //创建一个左节点
        TreeNode rootL = new TreeNode(2);
        //把新创建的节点设置为根节点的子节点
        root.setLeftNode(rootL);
        //创建一个右节点
        TreeNode rootR = new TreeNode(3);
        //把新创建的节点设置为根节点的子节点
        root.setRightNode(rootR);
        //为第二层的左节点创建两个子节点
        rootL.setLeftNode(new TreeNode(4));
        rootL.setRightNode(new TreeNode(5));
        //为第二层的右节点创建两个节点
        rootR.setLeftNode(new TreeNode(6));
        rootR.setRightNode(new TreeNode(7));
        //前序遍历树
        binaryTree.frontShow();
        //中序、后序同理
        System.out.println("===================================");
        //前序查找
        TreeNode result = binaryTree.frontSearch(3);
        System.out.println(result);
        //删除一个子树
        System.out.println("============================================");
        binaryTree.delete(5);
        binaryTree.frontShow();


    }
}
