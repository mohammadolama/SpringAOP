package com.example.springaopspring.services;

import com.example.springaopspring.models.dto.Message;
import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.example.springaopspring.models.dto.response.Response;
import com.example.springaopspring.models.dto.response.SuccessFulResponseDto;

public interface DaoService {

    public int saveRequest(RequestBodyDto requestBodyDto);

    public int saveResponse(SuccessFulResponseDto responseBodyDto, int i);

    Message getResponseWithId(int id);

    Message getRequestWithId(int id);

    Message deleteRequestById(int id);

    Message deleteResponseById(int id);

    Message updateRequest(RequestBodyDto requestBodyDto , int id);
}
