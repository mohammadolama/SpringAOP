package com.example.springaopspring.dao;

import com.example.springaopspring.models.entities.AppLogsEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostgresInformationRepository extends CrudRepository<AppLogsEntity, Integer> {

}
