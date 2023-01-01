package com.example.springaopspring.models.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class AppLogsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String url;
    private String requestBody;
    private int httpStatusCode;
    private LocalDateTime localDateTime;
    private String responseBody;
    private String httpMethod;


    public AppLogsEntity(String username, String url, String requestBody, int httpStatusCode, LocalDateTime localDateTime, String responseBody, String httpMethod) {
        this.username = username;
        this.url = url;
        this.requestBody = requestBody;
        this.httpStatusCode = httpStatusCode;
        this.localDateTime = localDateTime;
        this.responseBody = responseBody;
        this.httpMethod = httpMethod;
    }

    public AppLogsEntity() {
    }
}
