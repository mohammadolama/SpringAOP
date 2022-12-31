package com.example.springaopspring.models.dto;

import com.example.springaopspring.models.dto.Message;
import lombok.Data;

@Data
public class ErrorMessage extends Message {

    String status;
    String message;


    public ErrorMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
