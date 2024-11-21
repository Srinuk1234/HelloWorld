package com.rest.jpa.curdOperations.service;

import com.rest.jpa.curdOperations.entity.Employee;
import com.rest.jpa.curdOperations.model.EmployeeRequest;
import com.rest.jpa.curdOperations.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public String saveEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employeeRepository.save(employee);
        return "Employee Saved Successfully";
    }
}
