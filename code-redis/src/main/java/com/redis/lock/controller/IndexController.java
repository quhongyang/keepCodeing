package com.redis.lock.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class IndexController {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private Redisson redisson;

    @RequestMapping("/deduct_stock")
    public String deductStock(){
        String lockKey = "lockKey";
        String clientId = UUID.randomUUID().toString();
        RLock lock = redisson.getLock(lockKey);
        try {
            lock.lock();
            Boolean result = redisTemplate.opsForValue().setIfAbsent(lockKey,"lockKsy",5, TimeUnit.SECONDS);
            if(result){
                System.out.println(2222);
            }
            return "8888";
        }catch (Exception e){
            log.error("error");
        }finally {
            lock.unlock();
            if(clientId.equalsIgnoreCase(redisTemplate.opsForValue().get(lockKey))){
                redisTemplate.delete(lockKey);
            }
        }
        return null;
    }
}
