package com.example.employeemangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeemangement.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
