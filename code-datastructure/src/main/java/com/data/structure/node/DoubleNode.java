package com.data.structure.node;

import com.sun.org.apache.regexp.internal.RE;

public class DoubleNode {
    //上一个节点
    DoubleNode pre = this;
    //下一个节点
    DoubleNode next = this;

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    //节点数据
    int data;

    public DoubleNode(int data) {
        this.data = data;
    }

    //增加节点
    public void after(DoubleNode node) {
        //原来的下一个节点
        DoubleNode nextNext = next;
        //把新节点作为当前节点的下一个节点
        this.next = node;
        //把当前节点做新节点的前一个节点
        node.pre = this;
        //让原来的下一个节点作为新节点的下一个节点
        node.next = nextNext;
        //让原来的下一个节点的上一节点为当前节点
        nextNext.pre = node;
    }

    //下一个节点
    public DoubleNode next() {
        return this.next;
    }

    //上一个节点
    public DoubleNode pre() {
        return this.pre;
    }
}
