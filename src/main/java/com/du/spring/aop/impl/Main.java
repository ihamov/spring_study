package com.du.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //创建Io容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-aop.xml");

        //获取实例
        ArithmeticCalculator calculator = applicationContext.getBean(ArithmeticCalculator.class);

        //使用bean
        int result = calculator.add(3, 6);
        System.out.println("result:"+result);

        result = calculator.div(12, 6);
        System.out.println("result:"+result);

    }
}
