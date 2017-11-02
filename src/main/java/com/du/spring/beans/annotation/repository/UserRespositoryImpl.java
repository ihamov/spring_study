package com.du.spring.beans.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository("userRespository")
public class UserRespositoryImpl implements UserRespository {

    @Override
    public void save() {
        System.out.println("UserRespository Save...");

    }

}
