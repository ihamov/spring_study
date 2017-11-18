package com.du.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 *  @Order 可以指定切面的优先级，值越小优先级越高
 */
@Order(value = 1)
@Aspect
@Component
public class VlidationAspect {

    @Before(value = "execution(* com.du.spring.aop.impl.ArithmeticCalculator.*(..))")
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("validate:"+ Arrays.asList(joinPoint.getArgs()));

    }
}
