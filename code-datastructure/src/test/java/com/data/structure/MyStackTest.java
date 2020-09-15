package com.data.structure;

import com.data.structure.stack.MyStack;

public class MyStackTest {
    public static void main(String[] args) {
        //创建一个栈
        MyStack myStack = new MyStack();
        //压入数组
        myStack.push(9);
        myStack.push(8);
        myStack.push(7);
//        int pop = myStack.pop();
//        System.out.println(pop);
        //最出栈顶元素
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
//        System.out.println(myStack.peek());
        System.out.println(myStack.isEmpty());
    }
}
