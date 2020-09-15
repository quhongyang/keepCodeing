package com.spring.code;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ReflectionUtils;
import sun.reflect.misc.ReflectUtil;

import java.lang.reflect.Proxy;

public class SourceCodeAnalysis {
    public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
//        ReflectionUtils.invokeMethod()

//        Proxy.newProxyInstance()
    }
}
