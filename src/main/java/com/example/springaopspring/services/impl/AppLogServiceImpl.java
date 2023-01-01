package com.example.springaopspring.services.impl;

import com.example.springaopspring.dao.PostgresInformationRepository;
import com.example.springaopspring.models.entities.AppLogsEntity;
import com.example.springaopspring.services.AppLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppLogServiceImpl implements AppLogService {

    private final PostgresInformationRepository repository;

    public AppLogServiceImpl(PostgresInformationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveLog(AppLogsEntity appLogsEntity) {
        repository.save(appLogsEntity);
    }
}
