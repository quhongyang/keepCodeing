package com.data.structure.node;

//一个节点
public class LoopNode {
    //节点内容
    int data;
    //下一个节点
    LoopNode next = this;

    public LoopNode(int data){
        this.data = data;
    }

    //获取下一个节点
    public LoopNode next(){
        return this.next;
    }
    public int getData(){
        return this.data;
    }
    //删除下一个节点
    public void removeNext(){
        //取出下下节点
        LoopNode newNext= next.next;
        //把下下节点设置为当前节点的下一个节点
        this.next= newNext;
    }

    //插入一个节点作为当前节点的下一个节点
    public void after(LoopNode node){
        //取出下一个节点作为下下一个节点
        LoopNode nextNext = next;
        //把新节点作为当前节点的下一个节点
        this.next = node;
        //把下下一个节点设置为新节点的下一个节点
        node.next = nextNext;

    }
}
