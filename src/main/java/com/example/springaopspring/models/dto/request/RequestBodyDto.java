package com.example.springaopspring.models.dto.request;

import lombok.Data;

@Data
public class RequestBodyDto extends Request {

    public RequestBodyDto() {
    }

    public RequestBodyDto(String username, String operation, double firstNumber, double secondNumber) {
        super(username, operation, firstNumber, secondNumber);
    }
}
