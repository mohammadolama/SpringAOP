package com.example.springaopspring.dao.mapper;

public interface DomainMapper<T, DomainModel> {

    DomainModel mapToDomainModel(T t);

    T mapFromDomainModel(DomainModel domainModel);
}
