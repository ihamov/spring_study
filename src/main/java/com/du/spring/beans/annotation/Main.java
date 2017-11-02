package com.du.spring.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.du.spring.beans.annotation.controller.UserController;
import com.du.spring.beans.annotation.repository.UserRespository;
import com.du.spring.beans.annotation.service.UserService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
        TestObject testObject = (TestObject) ctx.getBean("testObject");
        System.out.println(testObject);
        
        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        
        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println(userService);
        
        UserRespository userRespository = (UserRespository) ctx.getBean("userRespository");
        System.out.println(userRespository);
        
        
        userController.execute();
    }
}
