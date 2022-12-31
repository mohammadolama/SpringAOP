package com.example.springaopspring.dao;

import com.example.springaopspring.models.entities.RequestBodyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostgresRequestsRepository extends CrudRepository<RequestBodyEntity , Integer> {
}
