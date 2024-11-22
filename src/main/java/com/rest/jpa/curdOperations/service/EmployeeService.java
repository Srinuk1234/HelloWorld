package com.rest.jpa.curdOperations.service;

import com.rest.jpa.curdOperations.entity.Employee;
import com.rest.jpa.curdOperations.model.EmployeeRequest;
import com.rest.jpa.curdOperations.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    public String saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setAge(employeeRequest.getAge());
        employee.setGender(employeeRequest.getGender());
        employee.setDateOfJoin(employeeRequest.getDateOfJoin());
        employee.setStatus(employeeRequest.getStatus());
        employeeRepository.save(employee);
        return "Employee Saved Successfully";
    }


   public Employee getEmployee(long id) {
       return employeeRepository.findById(id).orElse(null);
    }


   public Employee updateEmployee(long id, EmployeeRequest empDetails){
       Employee employee = employeeRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
       if (empDetails.getName() != null) {
           employee.setName(empDetails.getName());
       }
       if (empDetails.getAge() > 0) { // Assuming age > 0 is valid
           employee.setAge(empDetails.getAge());
       }
       if (empDetails.getGender() != null) {
           employee.setGender(empDetails.getGender());
       }
       if (empDetails.getDateOfJoin() != null) {
           employee.setDateOfJoin(empDetails.getDateOfJoin());
       }
       if (empDetails.getStatus() != null) {
           employee.setStatus(empDetails.getStatus());
       }
        return employeeRepository.save(employee);
   }


   public String deleteEmp(Long id){
       Optional<Employee> employee = employeeRepository.findById(id);
       if (employee.isPresent()){
           employeeRepository.deleteById(id);
           return "Employee Delete Successfully";
       }else {
           return "Employee not found";
       }
   }
  public List<Employee> geAllEmployee(){
        return employeeRepository.findAll();
  }

}
