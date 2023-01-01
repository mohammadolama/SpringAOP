package com.example.springaopspring.models.dto.request;

import lombok.Data;

@Data
public class RequestByIdDto extends Request{

    int id;

    public RequestByIdDto(int id) {
        this.id = id;
    }
}
