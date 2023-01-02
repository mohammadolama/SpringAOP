package com.example.springaopspring.models.dto.response;

import lombok.Data;

@Data
public class SuccessMessage extends Message{

    public SuccessMessage(String status, String message) {
        super(status, message);
    }

    public SuccessMessage() {
    }
}
