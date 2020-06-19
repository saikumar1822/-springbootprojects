package com.service;

import java.util.List;

import com.applicationexception.InvalidEmployeeException;
import com.model.Employee;

public interface EmployeeService {
	public abstract Employee createEmployee(Employee employee);

	public abstract Employee readEmployeeById(int empId) throws InvalidEmployeeException;

	public abstract Employee readEmployeeByName(String empName);

	public abstract List<Employee> readEmployee();

	public abstract Employee updateEmployee(Employee employee);

	public abstract int deleteEmployeeById(int empId);

	public abstract void deleteEmployeeByName(String empName);

}
