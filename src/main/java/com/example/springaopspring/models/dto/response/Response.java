package com.example.springaopspring.models.dto.response;


import com.example.springaopspring.models.dto.Message;
import lombok.Data;

@Data
public abstract class Response extends Message {

    int requestId;

    public Response() {
    }

    public Response(String status, String message, int requestId) {
        super(status, message);
        this.requestId = requestId;
    }


}
