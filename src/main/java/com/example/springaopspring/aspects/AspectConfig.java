package com.example.springaopspring.aspects;

import com.example.springaopspring.models.dto.Message;
import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.example.springaopspring.models.entities.AppLogsEntity;
import com.example.springaopspring.services.AppLogService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class AspectConfig {

    private final AppLogService appLogService;

    public AspectConfig(AppLogService appLogService) {
        this.appLogService = appLogService;
    }

    @Pointcut("within(com.example.springaopspring.controllers.*)")
    public void allMethodsPointcut(){}


    @Pointcut("execution(* com.example.springaopspring.controllers.MathematicsController.postMath(*))")
    public void postMath(){}

    @Around("postMath()")
    public Object allServiceMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            log.info(proceedingJoinPoint.getArgs()[0].toString());
            String username = ((RequestBodyDto) proceedingJoinPoint.getArgs()[0]).getUsername();
            String uri = request.getRequestURI();
            RequestBodyDto bodyDto = (RequestBodyDto) proceedingJoinPoint.getArgs()[0];
            log.info("Before executing service method");
            LocalDateTime requestTime = LocalDateTime.now();
            String method = request.getMethod();

            Message responseMessage = (Message) proceedingJoinPoint.proceed();

            HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();


            int httpStatusCode = response.getStatus();

            log.info("After executing service method");


            AppLogsEntity appLogsEntity= new AppLogsEntity();
            appLogsEntity.setHttpMethod(method);
            appLogsEntity.setUrl(uri);
            appLogsEntity.setUsername(username);
            appLogsEntity.setRequestBody(bodyDto);
            appLogsEntity.setResponseBody(responseMessage);
            appLogsEntity.setHttpStatusCode(httpStatusCode);
            appLogsEntity.setLocalDateTime(requestTime);
            appLogService.saveLog(appLogsEntity);

            return responseMessage;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }


    @Before("within(com.example.springaopspring.controllers.*) && args(body)")
    public void before(RequestBodyDto body){
        System.out.println("before: " + body.toString());
    }

}
