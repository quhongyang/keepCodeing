package com.basic.api.codebasic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeInstance {
    public static Unsafe reflectFetUnsafe() {
        Field field = null;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
