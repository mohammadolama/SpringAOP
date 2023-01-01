package com.example.springaopspring.aspects;

import com.example.springaopspring.models.dto.Message;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Aspect
@Component
public class AspectConfig {


    @Pointcut("within(com.example.springaopspring.controllers.*)")
    public void allMethodsPointcut(){}


    @Around("allMethodsPointcut()")
    public Object allServiceMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Before executing service method");
        System.out.println(proceedingJoinPoint.getSignature());
        System.out.println(proceedingJoinPoint.getSourceLocation());
        System.out.println(Arrays.toString(proceedingJoinPoint.getArgs()));
        Message proceed = (Message) proceedingJoinPoint.proceed();


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        System.out.println(request.getRequestURI());
        System.out.println(response.getStatus());
        System.out.println(proceed);

        System.out.println("After executing service method");
        return proceed;
    }

}
