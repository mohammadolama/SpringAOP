package com.example.springaopspring;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
@SecurityScheme(name = "javainuseapi", scheme = "bearer", type = SecuritySchemeType.OAUTH2, in = SecuritySchemeIn.HEADER)
public class SpringAopSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopSpringApplication.class, args);
    }

}
