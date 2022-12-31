package com.example.springaopspring.dao.mapper;

import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.example.springaopspring.models.entities.RequestBodyEntity;

public class RequestMapper implements DomainMapper<RequestBodyDto , RequestBodyEntity> {
    @Override
    public RequestBodyEntity mapToDomainModel(RequestBodyDto requestBodyDto) {
        RequestBodyEntity requestBodyEntity = new RequestBodyEntity();
        requestBodyEntity.setInstructions(requestBodyDto.getOperation());
        requestBodyEntity.setFirstNumber(requestBodyDto.getFirstNumber());
        requestBodyEntity.setSecondNumber(requestBodyDto.getSecondNumber());
        requestBodyEntity.setUsername(requestBodyDto.getUsername());
        return requestBodyEntity;
    }

    @Override
    public RequestBodyDto mapFromDomainModel(RequestBodyEntity requestBodyEntity) {
        RequestBodyDto requestBodyDto = new RequestBodyDto();
        requestBodyDto.setFirstNumber(requestBodyEntity.getFirstNumber());
        requestBodyDto.setSecondNumber(requestBodyEntity.getSecondNumber());
        requestBodyDto.setOperation(requestBodyEntity.getInstructions());
        requestBodyDto.setUsername(requestBodyEntity.getUsername());
        return requestBodyDto;
    }
}
