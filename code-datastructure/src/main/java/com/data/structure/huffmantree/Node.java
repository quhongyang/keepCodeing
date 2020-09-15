package com.data.structure.huffmantree;

public class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public Node(int value) {
        this.value = value;

    }

    @Override
    public int compareTo(Node o) {
        return -(this.value-o.value);
    }
}
