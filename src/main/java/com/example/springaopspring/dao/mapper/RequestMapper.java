package com.example.springaopspring.dao.mapper;

import com.example.springaopspring.models.dto.RequestBodyDto;
import com.example.springaopspring.models.entities.RequestBodyEntity;

public class RequestMapper implements DomainMapper<RequestBodyDto , RequestBodyEntity> {
    @Override
    public RequestBodyEntity mapToDomainModel(RequestBodyDto requestBodyDto) {
        return null;
    }

    @Override
    public RequestBodyDto mapFromDomainModel(RequestBodyEntity requestBodyEntity) {
        return null;
    }
}
