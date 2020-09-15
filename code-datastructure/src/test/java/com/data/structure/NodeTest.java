package com.data.structure;

import com.data.structure.node.Node;

public class NodeTest {
    public static void main(String[] args) {
        //创建节点
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        //追加节点
        n1.append(n2).append(n3);
        //取出下一个节点的数据
//        System.out.println(n1.next().next().getData());
//        System.out.println(n1.next().next().next().isLast());
        System.out.println();
        n1.show();
        //删除一个节点
//        n1.next().removeNext();
//        n1.show();
        //插入一个新节点
        Node node = new Node(4);
        n1.next().after(node);
        n1.show();

    }
}
