package com.example.springaopspring.dao.mapper;

import com.example.springaopspring.models.dto.ResponseBodyDto;
import com.example.springaopspring.models.entities.ResponseBodyEntity;

public class ResponseMapper implements DomainMapper<ResponseBodyDto , ResponseBodyEntity> {
    @Override
    public ResponseBodyEntity mapToDomainModel(ResponseBodyDto responseBodyDto) {
        return null;
    }

    @Override
    public ResponseBodyDto mapFromDomainModel(ResponseBodyEntity responseBodyEntity) {
        return null;
    }
}
