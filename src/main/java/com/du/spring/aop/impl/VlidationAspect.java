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
    /**
     * 如果declareJoinPointExpression切点表达式不在同一包下，还需要加上包名才可以
     * @param joinPoint
     */
    @Before(value = "LoggingAspect.declareJoinPointExpression()")
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("validate:"+ Arrays.asList(joinPoint.getArgs()));

    }
}
