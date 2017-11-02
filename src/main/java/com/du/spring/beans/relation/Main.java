package com.du.spring.beans.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.du.spring.beans.autowire.Address;
import com.du.spring.beans.autowire.Person;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");
        Address address2 = (Address) ctx.getBean("address2");
        System.out.println(address2);
        Address address3 = (Address) ctx.getBean("address3");
        System.out.println(address3);
        
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }
}
