package com.example.springaopspring.models.dto.response;

import com.example.springaopspring.models.dto.request.Request;
import lombok.Data;

@Data
public class RequestMessage extends Message{

    Request request;

    public RequestMessage(String status, String message, Request request) {
        super(status, message);
        this.request = request;
    }

    public RequestMessage(Request request) {
        this.request = request;
    }
}
