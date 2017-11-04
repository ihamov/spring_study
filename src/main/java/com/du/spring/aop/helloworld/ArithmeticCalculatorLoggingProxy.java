package com.du.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {

    //要代理对象
    private ArithmeticCalculator target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    public ArithmeticCalculator getLoggingProxy(){
        ArithmeticCalculator proxy = null;

        //代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();

        //代理对象的类型，即其中有哪些方法
        Class[] interfaces = new Class[]{ArithmeticCalculator.class};

        //当调用代理对象其中的方法时，该执行的代码
        InvocationHandler handler = new InvocationHandler() {
            /**
             *
             * @param proxy 正在返回的代理对象，一般情况下，在invoke 方法中都不适用该对象。
             * @param method 正在被调用的方法
             * @param args 调用方法是传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //System.out.println(proxy.toString()); 调用proxy会导致死循环，最后内存溢出

                String methodName = method.getName();
                //日志
                System.out.println("The Method " + methodName + "begins with " + Arrays.asList(args));
                //执行方法
                Object result = method.invoke(target,args);
                //日志
                System.out.println("The Method " + methodName +"ends with " + result);
                return result;
            }
        };
        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader,interfaces,handler);

        return proxy;
    }
}