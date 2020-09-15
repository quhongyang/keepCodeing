package com.basic.api.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
        new Thread(() ->{
            System.out.println(Thread.currentThread().getName());
        }).start();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.execute();

    }

}
