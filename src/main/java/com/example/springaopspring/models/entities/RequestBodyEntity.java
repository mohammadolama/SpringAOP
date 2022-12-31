package com.example.springaopspring.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class RequestBodyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String username;

    String instructions;

    double firstNumber;

    double secondNumber;

    LocalDateTime createdAt = LocalDateTime.now();

    LocalDateTime modifiedAt = LocalDateTime.now();

}
