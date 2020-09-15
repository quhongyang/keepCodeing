package com.redis.lock.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RedisLockUtils {

    private RedisTemplate<String, String> redisTemplate;

    public void rediskLock() {
        String uuid = UUID.randomUUID().toString();
        //1.占分布式锁 相当于set lock xxx NX 命令
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", "111");
        //2.加redis的原子命令 set lock 111 EX 300 NX 原子命令
        Boolean lock1 = redisTemplate.opsForValue().setIfAbsent("lock", "1111", 300, TimeUnit.DAYS);
        if (lock) {
            redisTemplate.expire("lock",30, TimeUnit.SECONDS);
            //加锁成功 执行业务
            redisTemplate.delete("lock");
            //安全删锁
            String lockValue = redisTemplate.opsForValue().get("lock");
            if(uuid.equals(lockValue)){
                redisTemplate.delete("lock");
            }
            //改进 获取值对比+对比成功删除 = 原子操作 Lua脚本
            String script = "if redis.call(\"get\",KEYS[1]) == ARGV[1]\n" +
                    "then\n" +
                    "    return redis.call(\"del\",KEYS[1])\n" +
                    "else\n" +
                    "    return 0\n" +
                    "end";
            //执行脚本 原子删除锁 推荐
            redisTemplate.execute(new DefaultRedisScript<Long>(script,Long.class), Arrays.asList("lock"),uuid);

            //简化业务代码
            return;
        }else {
            //加锁失败、重试
            return ;
        }

    }
}
