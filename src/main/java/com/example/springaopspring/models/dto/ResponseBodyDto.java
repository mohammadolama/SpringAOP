package com.example.springaopspring.models.dto;

import lombok.Data;

@Data
public class ResponseBodyDto {

    String requestId;
    String responseId;
    String status;
    String message;
    double result;

}
