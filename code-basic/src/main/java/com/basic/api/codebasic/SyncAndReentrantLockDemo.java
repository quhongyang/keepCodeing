package com.basic.api.codebasic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：多线程之间按顺序掉用，实现A->B->C三个线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 紧接着
 * AA打印5次，BB打印10次，CC打印15次
 * 。。。。
 * 10轮
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 1; i <10 ; i++) {
                shareResource.print5();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 1; i <10 ; i++) {
                shareResource.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 1; i <10 ; i++) {
                shareResource.print15();
            }
        },"C").start();
    }

}

class ShareResource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void print5(){
        lock.lock();
        try {
            while (number != 1){
                c1.await();
            }
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName() +"\t" + i);
            }
            //通知B
            number = 2;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
    public void print10(){
        lock.lock();
        try {
            while (number != 2){
                c2.await();
            }
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName() +"\t" + i);
            }
            //通知B
            number = 3;
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }

    public void print15(){
        lock.lock();
        try {
            while (number != 3){
                c3.await();
            }
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName() +"\t" + i);
            }
            //通知A
            number = 1;
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}
