package com.example.springaopspring.models.dto;

import lombok.Data;

@Data
public abstract class Message {
    String status;
    String message;

    public Message(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public Message() {
    }

}
