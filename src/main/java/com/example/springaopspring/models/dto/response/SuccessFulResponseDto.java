package com.example.springaopspring.models.dto.response;

import lombok.Data;

@Data
public class SuccessFulResponseDto extends Response {

    int responseId;
    double result;

}
