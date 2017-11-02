package com.du.spring.beans;

public class HelloWorld {
    
    private String name;
    
    public void setName(String name){
        this.name = name;
        System.out.println("method call");
    }
    
    public void hello(){
        System.out.println("hello: "+name);
    }

    public HelloWorld() {
        System.out.println("helloworld create");
    }
    
    
}
