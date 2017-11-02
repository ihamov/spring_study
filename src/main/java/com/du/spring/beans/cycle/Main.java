package com.du.spring.beans.cycle;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");
        Car car = (Car) ctx.getBean("car");
        System.out.println(car);
        ctx.close();
        
    }
}
