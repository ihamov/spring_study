package com.du.spring.beans.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.du.spring.beans.annotation.service.UserService;

@Controller
public class UserController {
    
    /**
     * 可以设置required=false,即使该bean没有装配上，启动时也不会报错
     */
    @Autowired
    private UserService userService;
    
    public void execute(){
        System.out.println("UserController execute...");
        userService.add();
    }
}
