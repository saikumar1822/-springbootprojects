package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applicationexception.InvalidEmployeeException;
import com.dao.EmployeeDao;
import com.model.Employee;
@Service
public class EmployeeServiceImpl  implements EmployeeService{

	
	//dao
	@Autowired
	private EmployeeDao employeeDao;
	
	
	
	@Override
	public Employee createEmployee(Employee employee) {
		Employee localEmployee =null;
		
		if(employee!=null && employee.getEmpName().length()>0){
		localEmployee=this.employeeDao.createEmployee(employee);
		}
		else
		{
			
		}
		return localEmployee;
	}

	@Override
	public Employee readEmployeeById(int empId) throws InvalidEmployeeException {
		Employee employee =null;
		if(empId<0){
			throw new InvalidEmployeeException();
		}
		else{
			employee= new Employee("saikrishna",10);
			
		}
		return employee;
	}

	@Override
	public Employee readEmployeeByName(String empName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> readEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteEmployeeById(int empId) {
		employeeDao.deleteEmployeeById(empId);
		return empId;
	}

	@Override
	public void deleteEmployeeByName(String empName) {
		employeeDao.deleteEmployeeByName(empName);
		
	}

}
