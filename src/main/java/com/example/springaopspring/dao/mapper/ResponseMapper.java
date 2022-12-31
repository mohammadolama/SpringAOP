package com.example.springaopspring.dao.mapper;

import com.example.springaopspring.models.dto.response.SuccessFulResponseDto;
import com.example.springaopspring.models.entities.ResponseBodyEntity;

public class ResponseMapper implements DomainMapper<SuccessFulResponseDto, ResponseBodyEntity> {
    @Override
    public ResponseBodyEntity mapToDomainModel(SuccessFulResponseDto responseBodyDto) {
        ResponseBodyEntity responseBodyEntity = new ResponseBodyEntity();
        responseBodyEntity.setMessage(responseBodyDto.getMessage());
        responseBodyEntity.setStatus(responseBodyDto.getStatus());
        responseBodyEntity.setResult(responseBodyDto.getResult());
        return responseBodyEntity;
    }

    @Override
    public SuccessFulResponseDto mapFromDomainModel(ResponseBodyEntity responseBodyEntity) {
        SuccessFulResponseDto responseBodyDto = new SuccessFulResponseDto();
        responseBodyDto.setResponseId(responseBodyEntity.getId());
        responseBodyDto.setResult(responseBodyEntity.getResult());
        responseBodyDto.setMessage(responseBodyEntity.getMessage());
        responseBodyDto.setStatus(responseBodyEntity.getStatus());
        return responseBodyDto;
    }
}
