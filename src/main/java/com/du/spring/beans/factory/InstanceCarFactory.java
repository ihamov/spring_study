package com.du.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;
/**
 * 实例工厂方法：需要创建工厂本身，再调用工厂的实例方法来返回bean的实例
 * @author Vigo
 *
 */
public class InstanceCarFactory {
    
    private Map<String, Car> cars = null;
    
    public InstanceCarFactory(){
        cars = new HashMap<String, Car>();
        cars.put("audi", new Car("audi", 3000000));
        cars.put("ford", new Car("ford", 4000000));
    }
    
    public Car getCar(String name){
            
        return cars.get(name);
            
    }
}
