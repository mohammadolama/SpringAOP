package com.example.springaopspring.models.dto.response;

import com.example.springaopspring.models.dto.response.Message;
import lombok.Data;

@Data
public class ErrorMessage extends Message {


    public ErrorMessage() {
    }

    public ErrorMessage(String status, String message) {
        super(status, message);
    }
}
