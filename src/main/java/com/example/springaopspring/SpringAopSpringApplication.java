package com.example.springaopspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringAopSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopSpringApplication.class, args);
    }

}
