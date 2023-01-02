package com.example.springaopspring.services.impl;

import com.example.springaopspring.dao.PostgresRequestsRepository;
import com.example.springaopspring.dao.PostgresResponseRepository;
import com.example.springaopspring.dao.mapper.DomainMapper;
import com.example.springaopspring.models.dto.request.Request;
import com.example.springaopspring.models.dto.response.*;
import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.example.springaopspring.models.entities.RequestBodyEntity;
import com.example.springaopspring.models.entities.ResponseBodyEntity;
import com.example.springaopspring.services.DaoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PostgresqlDaoService implements DaoService {

    private final PostgresRequestsRepository requestsRepository;

    private final PostgresResponseRepository responseRepository;

    private final DomainMapper<RequestBodyDto, RequestBodyEntity> requestMapper;

    private final DomainMapper<ResponseMessage, ResponseBodyEntity> responseMapper;

    public PostgresqlDaoService(PostgresRequestsRepository requestsRepository, PostgresResponseRepository responseRepository, DomainMapper<RequestBodyDto, RequestBodyEntity> requestMapper, DomainMapper<ResponseMessage, ResponseBodyEntity> responseMapper) {
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
    public int saveResponse(ResponseMessage responseBodyDto, int i) {
        ResponseBodyEntity responseBodyEntity = responseMapper.mapToDomainModel(responseBodyDto);
        responseBodyEntity.setRequestId(i);
        ResponseBodyEntity save = responseRepository.save(responseBodyEntity);
        return save.getId();

    }

    @Override
    public Message getResponseWithId(int id) {
        Optional<ResponseBodyEntity> entity = responseRepository.findById(id);

        if (entity.isEmpty()) {
            return new ErrorMessage("NOT FOUND", String.format("Response with id %d does not exist.", id));
        } else {
            return responseMapper.mapFromDomainModel(entity.get());

        }
    }

    @Override
    public Message getRequestWithId(int id) {
        Optional<RequestBodyEntity> entity = requestsRepository.findById(id);
        if (entity.isEmpty()) {
            return new ErrorMessage("NOT FOUND", String.format("Request with id %d does not exist.", id));
        }
        return new RequestMessage("OK" , String.format("Request with id %d has been found.", id),
                requestMapper.mapFromDomainModel(entity.get()));
    }

    @Override
    public Message deleteRequestById(int id) {
        boolean b = requestsRepository.existsById(id);
        if (b) {
            requestsRepository.deleteById(id);
            return new SuccessMessage("Success", String.format("Request with id %d has been deleted.", id));
        } else {
            return new ErrorMessage("NOT FOUND", String.format("Request with id %d does not exist.", id));
        }
    }

    @Override
    public Message deleteResponseById(int id) {

        boolean b = responseRepository.existsById(id);
        if (b) {
            responseRepository.deleteById(id);
            return new SuccessMessage("Success", String.format("Request with id %d has been deleted.", id));
        } else {
            return new ErrorMessage("NOT FOUND", String.format("Request with id %d does not exist.", id));
        }
    }

    @Override
    public Message updateRequest(RequestBodyDto requestBodyDto, int id) {
        final boolean[] updated = {false};
        String updateString = "The request has benn successfully updated.";
        String errorString = "Your Request was not found in the database.";
        requestsRepository.findById(id)
                .map(req -> {
                    req.setUsername(requestBodyDto.getUsername());
                    req.setFirstNumber(requestBodyDto.getFirstNumber());
                    req.setSecondNumber(requestBodyDto.getSecondNumber());
                    req.setInstructions(requestBodyDto.getOperation());
                    req.setModifiedAt(LocalDateTime.now());
                    updated[0] = true;
                    return requestsRepository.save(req);
                });
        if (updated[0]){
            RequestBodyDto requestBodyDto1 = requestMapper.mapFromDomainModel(requestsRepository.findById(id).get());
            return new UpdateRequestMessage("OK" , updateString , requestBodyDto1);
        }else {
            return new ErrorMessage("NOT FOUND", errorString);
        }
    }
}
