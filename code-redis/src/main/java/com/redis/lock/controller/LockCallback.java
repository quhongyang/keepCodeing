package com.redis.lock.controller;

import com.sun.istack.internal.NotNull;

/**
 * 锁回调方法
 */
public interface LockCallback {
    @NotNull
    void execute();

}
