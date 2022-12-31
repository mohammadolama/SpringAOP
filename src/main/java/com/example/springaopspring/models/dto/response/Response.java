package com.example.springaopspring.models.dto.response;


import com.example.springaopspring.models.dto.Message;
import lombok.Data;

@Data
public abstract class Response extends Message {

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
