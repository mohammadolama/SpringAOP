package com.example.springaopspring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {


    @Pointcut("within(com.example.springaopspring.controllers.*)")
    public void allMethodsPointcut(){}


    @Around("allMethodsPointcut()")
    public Object allServiceMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Before executing service method");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("After executing service method");
        return proceed;
    }

}
