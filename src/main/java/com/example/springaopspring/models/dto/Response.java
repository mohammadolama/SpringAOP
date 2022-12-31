package com.example.springaopspring.models.dto;


import lombok.Data;

@Data
public abstract class Response {

    int requestId;
    String status;
    String message;

    public Response() {
    }

    public Response(int requestId, String status, String message) {
        this.requestId = requestId;
        this.status = status;
        this.message = message;
    }
}
