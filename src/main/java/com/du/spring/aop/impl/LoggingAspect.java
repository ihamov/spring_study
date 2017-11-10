package com.du.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
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
    @Before(value = "execution(public int com.du.spring.aop.impl.ArithmeticCalculator.*(int, int))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The Method "+ methodName +"begins with : " + args);
    }
}
