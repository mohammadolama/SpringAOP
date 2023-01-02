package com.example.springaopspring.models.dto.response;

import com.example.springaopspring.models.dto.request.Request;
import lombok.Data;

@Data
public class UpdateRequestMessage extends Message{

    Request request;

    public UpdateRequestMessage(String status, String message, Request request) {
        super(status, message);
        this.request = request;
    }

    public UpdateRequestMessage(Request request) {
        this.request = request;
    }
}
