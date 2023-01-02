package com.example.springaopspring.dao.mapper;

import com.example.springaopspring.models.dto.response.ResponseMessage;
import com.example.springaopspring.models.entities.ResponseBodyEntity;

public class ResponseMapper implements DomainMapper<ResponseMessage, ResponseBodyEntity> {
    @Override
    public ResponseBodyEntity mapToDomainModel(ResponseMessage responseBodyDto) {
        ResponseBodyEntity responseBodyEntity = new ResponseBodyEntity();
        responseBodyEntity.setMessage(responseBodyDto.getMessage());
        responseBodyEntity.setStatus(responseBodyDto.getStatus());
        responseBodyEntity.setResult(responseBodyDto.getResult());
        return responseBodyEntity;
    }

    @Override
    public ResponseMessage mapFromDomainModel(ResponseBodyEntity responseBodyEntity) {
        ResponseMessage responseBodyDto = new ResponseMessage();
        responseBodyDto.setRequestId(responseBodyEntity.getRequestId());
        responseBodyDto.setResponseId(responseBodyEntity.getId());
        responseBodyDto.setResult(responseBodyEntity.getResult());
        responseBodyDto.setMessage(responseBodyEntity.getMessage());
        responseBodyDto.setStatus(responseBodyEntity.getStatus());
        return responseBodyDto;
    }
}
