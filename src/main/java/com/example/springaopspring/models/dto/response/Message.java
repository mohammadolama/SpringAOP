package com.example.springaopspring.models.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class Message implements Serializable {
    String status;
    String message;

    public Message(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public Message() {
    }

}
