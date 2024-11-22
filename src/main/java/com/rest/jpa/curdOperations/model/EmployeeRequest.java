package com.rest.jpa.curdOperations.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class EmployeeRequest {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String gender;
    private LocalDateTime dateOfJoin;
    private String status;



}
