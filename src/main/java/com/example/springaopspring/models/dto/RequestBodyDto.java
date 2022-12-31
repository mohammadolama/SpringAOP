package com.example.springaopspring.models.dto;

import lombok.Data;

@Data
public class RequestBodyDto {

    String username;
    String operation;
    double firstNumber;
    double secondNumber;
}
