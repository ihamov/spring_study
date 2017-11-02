package com.du.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
       /* //创建对象
        HelloWorld helloWorld = new HelloWorld();
        //属性赋值
        helloWorld.setName("Jerry");*/
        
        
        //1.创建IOC容器
        /**
         * ApplicationContext:代表IOC容器
         * 主要实现类：ClassPathXmlApplicationContext从类路径下加载配置文件
         */
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.从容器中获取bean
        //利用id定位到IOC容器中的bean
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
        //利用类型返回IOC容器中的bean，但要求IOC容器中必须只能有一个该类型的bean
        //HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        
        //调用方法
        helloWorld.hello();
        
        Car car = (Car) ctx.getBean("car");
        System.out.println(car);
        
        Car car2 = (Car) ctx.getBean("car2");
        System.out.println(car2);
        
        Person person = (Person) ctx.getBean("person2");
        System.out.println(person);
        
        
    }
}
