package com.rest.jpa.crudOperations.model;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeRequest {
    private Long id;
    private String name;
    private int age;
    private String gender;
    private LocalDateTime dateOfJoin;
    private String status;



}
