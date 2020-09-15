package com.data.structure;

import com.data.structure.node.DoubleNode;

public class DoubleNodeTest {
    public static void main(String[] args) {
        //创建节点
        DoubleNode n1 = new DoubleNode(1);
        DoubleNode n2 = new DoubleNode(2);
        DoubleNode n3 = new DoubleNode(3);
        //追加节点
        n1.after(n2);
        n2.after(n3);
        //查看上一个，自己，下一个节点的内容
        System.out.println(n2.pre().getData());
        System.out.println(n2.getData());
        System.out.println(n2.next().getData());


    }
}
