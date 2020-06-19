package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
