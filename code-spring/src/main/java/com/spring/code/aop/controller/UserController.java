package com.spring.code.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/login/{id}")
    public void login(@PathVariable int id){
        System.out.println(id);
    }
}
