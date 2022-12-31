package com.example.springaopspring.dao.mapper;

import com.example.springaopspring.models.dto.ResponseBodyDto;
import com.example.springaopspring.models.entities.ResponseBodyEntity;

public class ResponseMapper implements DomainMapper<ResponseBodyDto , ResponseBodyEntity> {
    @Override
    public ResponseBodyEntity mapToDomainModel(ResponseBodyDto responseBodyDto) {
        ResponseBodyEntity responseBodyEntity = new ResponseBodyEntity();
        responseBodyEntity.setMessage(responseBodyDto.getMessage());
        responseBodyEntity.setStatus(responseBodyDto.getStatus());
        responseBodyEntity.setResult(responseBodyDto.getResult());
        return responseBodyEntity;
    }

    @Override
    public ResponseBodyDto mapFromDomainModel(ResponseBodyEntity responseBodyEntity) {
        ResponseBodyDto responseBodyDto = new ResponseBodyDto();
        responseBodyDto.setResponseId(responseBodyEntity.getId());
        responseBodyDto.setResult(responseBodyEntity.getResult());
        responseBodyDto.setMessage(responseBodyEntity.getMessage());
        responseBodyDto.setStatus(responseBodyEntity.getStatus());
        return responseBodyDto;
    }
}
