package com.data.structure.huffmancode;

public class Node implements Comparable<Node>{
    private Byte data;
    private int weight;

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getWeight() {
        return weight;
    }

    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return o.weight-this.weight;
    }
}
