package com.example.springaopspring.services;

import com.example.springaopspring.models.dto.response.Message;
import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.example.springaopspring.models.dto.response.ResponseMessage;

public interface DaoService {

    public int saveRequest(RequestBodyDto requestBodyDto);

    public int saveResponse(ResponseMessage responseBodyDto, int i);

    Message getResponseWithId(int id);

    Message getRequestWithId(int id);

    Message deleteRequestById(int id);

    Message deleteResponseById(int id);

    Message updateRequest(RequestBodyDto requestBodyDto , int id);
}
