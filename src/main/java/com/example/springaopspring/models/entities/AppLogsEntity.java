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
    private String httpStatusCode;
    private LocalDateTime localDateTime;
    private String responseBody;
    private String httpMethod;


}
