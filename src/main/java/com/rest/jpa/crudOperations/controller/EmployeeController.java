package com.rest.jpa.crudOperations.controller;

import com.rest.jpa.crudOperations.entity.Employee;
import com.rest.jpa.crudOperations.model.EmployeeRequest;
import com.rest.jpa.crudOperations.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")

public class EmployeeController {
     @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String healthCheck() {
        return "Up and Running Successfully";
    }

    @PostMapping("/")
    public String saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.saveEmployee(employeeRequest);
    }

   @GetMapping("/findById")
   public ResponseEntity<Employee> getEmployee(@RequestParam int id) {
       Employee employee = employeeService.getEmployee(id);
       if (employee != null) {
           return ResponseEntity.ok(employee);
       } else {
           return ResponseEntity.notFound().build();
       }
   }

   @PutMapping("/updateEmployee/{id}")
   public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest empDetails){
    Employee updateEmployee = employeeService.updateEmployee(id,empDetails);
    return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
   }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmp(@PathVariable long id){
       String res = employeeService.deleteEmp(id);
        if (res.equals("Employee Delete Successfully")) {
            // If deletion was successful, return 200 OK with the success message
            return ResponseEntity.ok(res);
        } else {
            // If the employee wasn't found, return 404 Not Found with the error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }

    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> geAllEmployee() {
        List<Employee> employeeList = employeeService.geAllEmployee();
       return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.getEmployee(id);
        return ResponseEntity.ok(employee);
    }


}
