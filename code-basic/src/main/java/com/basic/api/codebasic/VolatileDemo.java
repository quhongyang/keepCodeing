package com.basic.api.codebasic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class VolatileDemo {
    volatile int num =0;
    public void addNum(){
        num++;
    }
    AtomicInteger atomicInteger = new AtomicInteger();
    AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public void atomicDemo(){

        atomicInteger.incrementAndGet();
    }


    public static void main(String[] args) {
        VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 1; i <=20 ; i++) {
            for (int j = 1; j <= 1000; j++) {
                new Thread(()->{
                    volatileDemo.addNum();
                    volatileDemo.atomicDemo();
                }).start();
            }
            while (Thread.activeCount()>2){
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() +"===="+volatileDemo.num);
            System.out.println(Thread.currentThread().getName() +"****"+volatileDemo.atomicInteger);
        }
    }
}
