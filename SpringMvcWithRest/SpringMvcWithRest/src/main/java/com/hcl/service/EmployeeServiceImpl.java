package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.Dao.EmployeeDao;
import com.hcl.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee addEmployee(Employee employee) {

		return employeeDao.addEmployee(employee);

	}

	@Override
	public Employee getEmployeeById(Long empId) {
		return employeeDao.getEmployeeById(empId);

	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public Employee deleteEmployee(Employee employee) {
		return employeeDao.deleteEmployee(employee);
	}

	@Override
	public Long deleteEmployeeById(Long empId) {
		return employeeDao.deleteEmployeeById(empId);
	
	}

}
