package com.spring.code.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TesetUserService {

    @Test
    public void test() throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        UserService userService = new UserService();
        userController.setUserService(userService);
//        System.out.println(userController.getUserService());
        System.out.println(userService);
        //通过反射set对象
//        //获取所有属性
        Field serviceField = clazz.getDeclaredField("userService");
        serviceField.setAccessible(true);
        String name = serviceField.getName();
        name = name.substring(0,1).toUpperCase() + name.substring(1,name.length());
        String setMethodName = "set" + name;
        //通过方法注入属性对象
        Method method = clazz.getMethod(setMethodName, UserService.class);
        method.invoke(userController,userService);
        System.out.println(userController.getUserService());
    }


}
