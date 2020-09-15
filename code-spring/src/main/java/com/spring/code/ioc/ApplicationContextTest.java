package com.spring.code.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContextTest {

    public void testApplicationContext(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean1.xml");
        Object user = beanFactory.getBean("user");
        synchronized (this){

        }
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>(16);
        concurrentHashMap.put("a","b");
        concurrentHashMap.get("a");
    }
}
