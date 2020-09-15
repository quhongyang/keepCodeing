package com.data.structure;

import com.data.structure.tree.BinarySortTree;
import com.data.structure.tree.BinarySortTreeNode;

public class BinarySortTreeTest {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,10,12,5,1,9};
        //创建一颗二叉排序树
        BinarySortTree bst =new BinarySortTree();
        //循环添加
        for (int i:arr) {
            bst.add(new BinarySortTreeNode(i));
        }
        //查看树中的值
        bst.frontShow();
        //查找
        BinarySortTreeNode node = bst.search(10);
        System.out.println(node.getValue());
        BinarySortTreeNode node2 = bst.search(20);
        System.out.println(node2);
    }
}
