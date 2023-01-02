package com.example.springaopspring.aspects;

import com.example.springaopspring.models.dto.response.Message;
import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.example.springaopspring.models.entities.AppLogsEntity;
import com.example.springaopspring.services.AppLogService;
import com.example.springaopspring.utils.JwtExtractor;
import lombok.extern.slf4j.Slf4j;
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
import java.time.LocalDateTime;

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

    @Around("allMethodsPointcut()")
    public Object allServiceMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            String username = JwtExtractor.username((String) proceedingJoinPoint.getArgs()[0]);
            String uri = request.getRequestURI();
            RequestBodyDto bodyDto = proceedingJoinPoint.getArgs()[1] instanceof RequestBodyDto ?(RequestBodyDto) proceedingJoinPoint.getArgs()[1] : null;
            log.info("Before executing service method");
            LocalDateTime requestTime = LocalDateTime.now();
            String method = request.getMethod();

            Message responseMessage = (Message) proceedingJoinPoint.proceed();

            HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();


            int httpStatusCode = response.getStatus();

            log.info("After executing service method");

            log.info(responseMessage.toString());


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
