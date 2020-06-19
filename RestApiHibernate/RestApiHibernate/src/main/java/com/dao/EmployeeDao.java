package com.dao;

import java.util.List;

import com.model.*;

public interface EmployeeDao {
	public abstract Employee createEmployee(Employee employee);

	public abstract Employee readEmployeeById(int empId);

	public abstract Employee readEmployeeByName(String empName);

	public abstract List<Employee> readEmployee();

	public abstract Employee updateEmployee(Employee employee);

	public abstract Employee deleteEmployeeById(int empId);

	public abstract void deleteEmployeeByName(String empName);
}
