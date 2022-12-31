package com.example.springaopspring.services;

import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.example.springaopspring.models.dto.response.SuccessFulResponseDto;

public interface MathService {

    public SuccessFulResponseDto doMath(RequestBodyDto requestBodyDto);
}
