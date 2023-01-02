package com.example.springaopspring.models.dto.response;

import lombok.Data;

@Data
public class UpdateResponseMessage extends Message{

    int responseId;
    double result;


    public UpdateResponseMessage(String status, String message, int responseId, double result) {
        super(status, message);
        this.responseId = responseId;
        this.result = result;
    }

    public UpdateResponseMessage(int responseId, double result) {
        this.responseId = responseId;
        this.result = result;
    }
}
