package com.du.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect  //声明为一个切面
@Component //将该切面放入Ioc容器
public class LoggingAspect {

    /**
     * 声明该方法是一个前置通知：
     * 在目标方法开始执行之前执行
     * JoinPoint可以获取到一些连接细节，例如方法名，参数等
     */
    @Before(value = "execution(* com.du.spring.aop.impl.ArithmeticCalculator.*(int, int))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The Method "+ methodName +"begins with : " + args);
    }

    //后置通知：在目标方法执行后(无论是否发生异常),执行通知
    //在后置通知中还不能访问目标方法执行的结果
    @After(value = "execution(* com.du.spring.aop.impl.ArithmeticCalculator.*(int, int))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The Method "+ methodName +" ends");

    }

}
