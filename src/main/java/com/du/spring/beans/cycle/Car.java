package com.du.spring.beans.cycle;

public class Car {
    public Car() {
        System.out.println("Car's Constructor...");
    }
    
    private String brand;
    
    public void setBrand(String brand) {
        System.out.println("setBrand");
        this.brand = brand;
    }
    public void initTest() {
        System.out.println("initTest...");
    }
    public void destoryTest(){
        System.out.println("destoryTest...");
    }
}
