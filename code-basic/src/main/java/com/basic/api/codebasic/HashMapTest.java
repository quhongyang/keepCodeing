package com.basic.api.codebasic;

import org.junit.Test;

import java.util.HashMap;

public class HashMapTest {

    @Test
    public void testHashMap(){
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"a");
        String key = "a";
        int h ;
        System.out.println((h = key.hashCode()) ^ (h >>> 16));


    }
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
