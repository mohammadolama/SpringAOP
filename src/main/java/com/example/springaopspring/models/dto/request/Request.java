package com.example.springaopspring.models.dto.request;

import com.example.springaopspring.models.dto.Message;
import lombok.Data;

@Data
public abstract class Request extends Message {

    String username;
    String operation;
    double firstNumber;
    double secondNumber;

    public Request() {
    }

    public Request(String username, String operation, double firstNumber, double secondNumber) {
        this.username = username;
        this.operation = operation;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
}
