package com.rest.jpa.curdOperations.controller;

import com.rest.jpa.curdOperations.model.EmployeeRequest;
import com.rest.jpa.curdOperations.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurdOperationController {

    private EmployeeService employeeService;

    public CurdOperationController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String healthCheck() {
        return "Up and Running Successfully";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(EmployeeRequest employeeRequest) {
        return employeeService.saveEmployee(employeeRequest);
    }

    @GetMapping("/saveEmployeeWithParam")
    public String getEmployee(@RequestParam String name) {
        EmployeeRequest employeeRequest=new EmployeeRequest();
        employeeRequest.setName(name);
        return employeeService.saveEmployee(employeeRequest);
    }

}
