package com.example.springaopspring.models.dto.response;

import lombok.Data;

@Data
public class ResponseMessage extends Message {

    int requestId;
    int responseId;
    double result;

    public ResponseMessage(String status, String message, int requestId, int responseId, double result) {
        super(status, message);
        this.requestId = requestId;
        this.responseId = responseId;
        this.result = result;
    }

    public ResponseMessage(int requestId, int responseId, double result) {
        this.requestId = requestId;
        this.responseId = responseId;
        this.result = result;
    }

    public ResponseMessage() {
    }
}
