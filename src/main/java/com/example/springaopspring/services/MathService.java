package com.example.springaopspring.services;

import com.example.springaopspring.models.dto.RequestBodyDto;
import com.example.springaopspring.models.dto.ResponseBodyDto;

public interface MathService {

    public ResponseBodyDto doMath(RequestBodyDto requestBodyDto);
}
