package com.du.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法：直接调用某个类的静态方法，返回bean的实例
 * @author Vigo
 *
 */
public class StaticCarFactory {
    
    private static Map<String, Car> cars  = new HashMap<String, Car>();
    
    static{
        cars.put("audi", new Car("audi", 3000000));
        cars.put("ford", new Car("ford", 4000000));
    }
    
    public static Car getCar(String name){
        
        return cars.get(name);
        
    }

}
