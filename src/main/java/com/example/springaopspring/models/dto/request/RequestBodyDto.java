package com.example.springaopspring.models.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestBodyDto extends Request implements Serializable {
    String operation;
    double firstNumber;
    double secondNumber;

    public RequestBodyDto() {
    }

    public RequestBodyDto(String operation, double firstNumber, double secondNumber) {
        this.operation = operation;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public String toString() {
        return "RequestBodyDto{" +
                ", operation='" + operation + '\'' +
                ", firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                '}';
    }
}
