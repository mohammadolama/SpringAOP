package com.example.springaopspring.services;

import com.example.springaopspring.models.entities.RequestBodyEntity;
import com.example.springaopspring.models.entities.ResponseBodyEntity;

public interface DaoService {

    public void saveRequest(RequestBodyEntity requestBodyEntity);

    public void saveResponse(ResponseBodyEntity responseBodyEntity);
}
