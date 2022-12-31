package com.example.springaopspring.services;

import com.example.springaopspring.models.dto.RequestBodyDto;
import com.example.springaopspring.models.dto.SuccessFulResponseDto;

public interface MathService {

    public SuccessFulResponseDto doMath(RequestBodyDto requestBodyDto);
}
