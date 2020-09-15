package com.spring.code.cache;

import org.springframework.cache.annotation.Cacheable;

import java.util.Arrays;
import java.util.List;

public class CacheTest {
    @Cacheable(key = "#id",cacheNames = "uuid::cache",unless ="#result == null")
    public List<String> getList(String id){
        return Arrays.asList("a");
    }
}
