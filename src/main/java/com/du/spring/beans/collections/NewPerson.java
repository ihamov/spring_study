package com.du.spring.beans.collections;

import java.util.Map;

import com.du.spring.beans.Car;

public class NewPerson {
    
    private String name;
    private int age;
    private Map<String, Car> cars;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    public Map<String, Car> getCars() {
        return cars;
    }
    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }
    public NewPerson() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "NewPerson [name=" + name + ", age=" + age + ", cars=" + cars
                + "]";
    }
    
    

}
