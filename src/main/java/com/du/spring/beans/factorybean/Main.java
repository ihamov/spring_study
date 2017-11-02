package com.du.spring.beans.factorybean;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-factorybean.xml");
        Car car = (Car) ctx.getBean("car");
        System.out.println(car);
        
    }
}
