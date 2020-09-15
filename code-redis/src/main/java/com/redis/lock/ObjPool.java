package com.redis.lock;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;

public class ObjPool<T, R> {
    final List<T> pool;
    final Semaphore semaphore;

    ObjPool(int size, T t) {
        pool = new Vector<T>() {
        };
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        semaphore = new Semaphore(size);
    }
}
