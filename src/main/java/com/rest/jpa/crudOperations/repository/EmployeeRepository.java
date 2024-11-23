package com.rest.jpa.crudOperations.repository;

import com.rest.jpa.crudOperations.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByIdAndStatus(Long id, String status);

    List<Employee> findByStatus(String status);
}
