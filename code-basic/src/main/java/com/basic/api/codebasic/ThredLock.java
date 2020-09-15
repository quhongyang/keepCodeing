package com.basic.api.codebasic;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.LockSupport;

public class ThredLock {

    //当前加锁状态，记录加锁次数
    private volatile int state = 0;

    //当前持有锁的线程
    private Thread lockHolder;

    private ConcurrentLinkedDeque<Thread> waiters = new ConcurrentLinkedDeque<>();

    public int getState() {
        return state;
    }

    public Thread getLockHolder() {
        return lockHolder;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setLockHolder(Thread lockHolder) {
        this.lockHolder = lockHolder;
    }

    public boolean acquire() {
        //比较与交换
        Thread current = Thread.currentThread();
        //初始状态
        int c = getState();
        if (c == 0) {
            if (waiters.size() == 0) {
                setLockHolder(current);
                return true;
            }

        }
        return false;
    }

    public void lock() {
        //加锁成功
        if(acquire()){
            return;
        }
        Thread current = Thread.currentThread();
        waiters.add(current);

        for (; ; ) {
            if(acquire()){
                break;
            }
            //阻塞当前线程
            LockSupport.park(current);//保存线程的引用

        }
    }


}
