package com.example.springaopspring.models.dto;

import lombok.Data;

@Data
public class ErrorResponseDto extends Response{

    public ErrorResponseDto(int requestId, String status, String message) {
        super(requestId, status, message);
    }
}
