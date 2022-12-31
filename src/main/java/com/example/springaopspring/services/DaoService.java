package com.example.springaopspring.services;

import com.example.springaopspring.models.dto.RequestBodyDto;
import com.example.springaopspring.models.dto.ResponseBodyDto;

public interface DaoService {

    public int saveRequest(RequestBodyDto requestBodyDto);

    public int saveResponse(ResponseBodyDto  responseBodyDto, int i);

    ResponseBodyDto getResponseWithId(int id);
}
