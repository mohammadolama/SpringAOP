package com.example.springaopspring.services;

import com.example.springaopspring.models.dto.RequestBodyDto;
import com.example.springaopspring.models.dto.Response;
import com.example.springaopspring.models.dto.SuccessFulResponseDto;

public interface DaoService {

    public int saveRequest(RequestBodyDto requestBodyDto);

    public int saveResponse(SuccessFulResponseDto responseBodyDto, int i);

    Response getResponseWithId(int id);
}
