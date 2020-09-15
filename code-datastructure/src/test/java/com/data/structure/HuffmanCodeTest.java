package com.data.structure;

import com.data.structure.huffmancode.Node;

import java.util.*;

public class HuffmanCodeTest {
    public static void main(String[] args) {
        String msg = "can you can a can as a can canner can a can";
        byte[] bytes = msg.getBytes();
        //进行赫夫曼编码
        byte[] b = huffmanZip(bytes);
    }

    /**
     * 进行赫夫曼编码压缩的方法
     * @param bytes
     * @return
     */
    private static byte[] huffmanZip(byte[] bytes) {
        //先统计每一个byte出现的次数，并放入一个集合中
        List<Node> nodes = getNodes(bytes);
        //创建一颗赫夫曼树
        Node tree = createHuffmanTree(nodes);
        System.out.println(tree);
        return null;
    }

    /**
     * 创建赫夫曼树
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node left = nodes.get(nodes.size()-1);
            Node right = nodes.get(nodes.size()-2);
            //创建一颗新的二叉树
            Node parent= new Node(null,left.getWeight()+right.getWeight());
            //把之前取出来的两颗二叉树设置为新创建的二叉树子树
            parent.setLeft(left);
            parent.setRight(right);
            nodes.remove(left);
            nodes.remove(right);
            //把新创建的二叉树放入集合中
            nodes.add(parent);
        }
        System.out.println(nodes + "+++++");
        return nodes.get(0);
    }

    /**
     * 把byte数组转为node集合
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes =new ArrayList<>();
        Map<Byte,Integer> counts =new HashMap<>();
        //统计每一个byte出现的次数
        for(byte b: bytes){
            Integer count = counts.get(b);
            if(count==null){
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }

        }
        System.out.println(counts);
        //把每个键值对转为一个对象
        for(Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
}
