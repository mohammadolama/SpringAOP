package com.example.springaopspring.models.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class ResponseBodyEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    int requestId;

    String status;

    String message;

    double result;

    String username;

    LocalDateTime createdAt = LocalDateTime.now();

    LocalDateTime modifiedAt = LocalDateTime.now();

}
