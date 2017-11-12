package com.du.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
        System.out.println("The Method "+ methodName +" begins with : " + args);
    }

    //后置通知：在目标方法执行后(无论是否发生异常),执行通知
    //在后置通知中还不能访问目标方法执行的结果
    @After(value = "execution(* com.du.spring.aop.impl.ArithmeticCalculator.*(int, int))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The Method "+ methodName +" ends");

    }

    //返回通知：在方法正常结束后执行的代码
    //可以访问到方法的返回值,在注解中指定该值
    //出现异常将执行不到
    @AfterReturning(value = "execution(* com.du.spring.aop.impl.ArithmeticCalculator.*(int, int))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The Method "+ methodName +" ends with: "+result);
    }

    /**
     * 异常通知：在目标方法出现异常时执行的代码
     * 可以访问到方法发生的异常信息，在注解中指定
     * 指定的异常类型也会决定该方法是否能够执行，例如设置为NullPointerException,
     * 但实际发生的是ArithmeticException，则该方法将不执行
     */
    @AfterThrowing(value = "execution(* com.du.spring.aop.impl.ArithmeticCalculator.*(int, int))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The Method "+ methodName +" occurs exception with: "+ex);

    }

}
