package com.example.springaopspring.services.impl;

import com.example.springaopspring.dao.PostgresRequestsRepository;
import com.example.springaopspring.dao.PostgresResponseRepository;
import com.example.springaopspring.dao.mapper.DomainMapper;
import com.example.springaopspring.models.dto.ErrorResponseDto;
import com.example.springaopspring.models.dto.RequestBodyDto;
import com.example.springaopspring.models.dto.Response;
import com.example.springaopspring.models.dto.SuccessFulResponseDto;
import com.example.springaopspring.models.entities.RequestBodyEntity;
import com.example.springaopspring.models.entities.ResponseBodyEntity;
import com.example.springaopspring.services.DaoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostgresqlDaoService implements DaoService {

    private final PostgresRequestsRepository requestsRepository;

    private final PostgresResponseRepository responseRepository;

    private final DomainMapper<RequestBodyDto , RequestBodyEntity> requestMapper;

    private final DomainMapper<SuccessFulResponseDto, ResponseBodyEntity> responseMapper;

    public PostgresqlDaoService(PostgresRequestsRepository requestsRepository, PostgresResponseRepository responseRepository, DomainMapper<RequestBodyDto, RequestBodyEntity> requestMapper, DomainMapper<SuccessFulResponseDto, ResponseBodyEntity> responseMapper) {
        this.requestsRepository = requestsRepository;
        this.responseRepository = responseRepository;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @Override
    public int saveRequest(RequestBodyDto requestBodyDto) {
        RequestBodyEntity save = requestsRepository.save(requestMapper.mapToDomainModel(requestBodyDto));
        return save.getId();
    }

    @Override
    public int saveResponse(SuccessFulResponseDto responseBodyDto, int i) {
        ResponseBodyEntity responseBodyEntity = responseMapper.mapToDomainModel(responseBodyDto);
        responseBodyEntity.setRequestId(i);
        ResponseBodyEntity save = responseRepository.save(responseBodyEntity);
        return save.getId();

    }

    @Override
    public Response getResponseWithId(int id) {
        Optional<ResponseBodyEntity> entity = responseRepository.findById(id);

        if (entity.isEmpty()){
            return new ErrorResponseDto(id , "NOT FOUND" , String.format("Response with id %d does not exist." , id));
        }else {
            return responseMapper.mapFromDomainModel(entity.get());

        }
    }
}
