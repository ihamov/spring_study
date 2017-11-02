package com.du.spring.beans.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.du.spring.beans.annotation.repository.UserRespository;


@Service
public class UserService {
    
    @Autowired//按类型进行注入
    @Qualifier("userJdbcRespository")//指定具体使用哪个bean
    private UserRespository userRespository;
    
    public void add(){
        System.out.println("UserService add...");
        userRespository.save();
    }
}
