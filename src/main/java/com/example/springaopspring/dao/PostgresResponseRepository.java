package com.example.springaopspring.dao;

import com.example.springaopspring.models.entities.ResponseBodyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostgresResponseRepository extends CrudRepository<ResponseBodyEntity , Integer> {
}
