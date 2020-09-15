package com.data.structure.recursive;

public class Febonaci {
    public static void main(String[] args) {
        //斐波那契数列  1 1 2 3 5 8 13
        int i = febonacci(4);
        System.out.println(i);

    }
    public static int febonacci(int i){
        if(i == 1 || i==2){
            return 1;
        }else {
            return febonacci(i-1)+febonacci(i-2);
        }
    }
}
