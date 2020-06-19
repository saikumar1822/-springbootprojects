package com.hcl.Dao;

import java.util.List;

import com.hcl.model.Employee;

public interface EmployeeDao {

	public Employee addEmployee(Employee employee);

	public Employee getEmployeeById(Long empId);

	public List<Employee> getAllEmployees();

	public Employee updateEmployee(Employee employee);

	public Employee deleteEmployee(Employee employee);

	public Long deleteEmployeeById(Long empId);

	
}
