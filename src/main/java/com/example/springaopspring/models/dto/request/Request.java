package com.example.springaopspring.models.dto.request;

import com.example.springaopspring.models.dto.Message;
import lombok.Data;

@Data
public abstract class Request extends Message {
    public Request() {
    }
}
