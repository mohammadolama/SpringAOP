package com.example.springaopspring.models.dto;

import lombok.Data;

@Data
public class ResponseBodyDto {

    int requestId;
    int responseId;
    String status;
    String message;
    double result;

}
