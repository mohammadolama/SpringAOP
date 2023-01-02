package com.example.springaopspring.services;

import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.example.springaopspring.models.dto.response.ResponseMessage;

public interface MathService {

    public ResponseMessage doMath(RequestBodyDto requestBodyDto);

}
