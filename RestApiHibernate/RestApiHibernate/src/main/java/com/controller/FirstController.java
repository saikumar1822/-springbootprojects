package com.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.applicationexception.InvalidEmployeeException;
import com.dao.EmployeeDao;
import com.model.Employee;
import com.service.EmployeeService;

@RestController
@Transactional
public class FirstController {
	@Autowired
	private EmployeeService employeeService;

	
	@GetMapping(value = "/first") // URI
	public String fun() {
		return "WELCOME TO RESTFULL SERVICE";
	}

	@GetMapping(value = "/read")
	public Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmpName("saikrishna");
		employee.setEmpNo(51836162);
		
		return employee;
	}

	@GetMapping(value = "/second/{EmpNo}")
	public Employee firstPage(@PathVariable int EmpNo) {
		if (EmpNo > 0) {
			Employee employee = new Employee();
			if (EmpNo == 22) {
				employee.setEmpName("saikrishna");
				employee.setEmpNo(22);
			}
			if (EmpNo == 23) {
				employee.setEmpName("krishna");
				employee.setEmpNo(23);
			}
			if (EmpNo == 24) {
				employee.setEmpName("sk");
				employee.setEmpNo(24);
			}
			if (EmpNo == 25) {
				employee.setEmpName("sai");
				employee.setEmpNo(25);
			}
			return employee;
		} else {
			return null;
		}

	}

	@GetMapping(value = "/readall", produces = { MediaType.APPLICATION_XML_VALUE })

	public List<Employee> getEmployees() {
		// egarloading
		// List<Employee> employees = new ArrayList<Employee>();

		Employee employee1 = new Employee("sai", 10);
		Employee employee2 = new Employee("krishna", 20);
		Employee employee3 = new Employee("venkat", 30);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);

		return employees;

	}

	@PostMapping(value = "/create")
	public Employee createOperation(@RequestBody Employee employee) {
		System.out.println("recevied emp no:" + employee.getEmpNo());
		System.out.println("recevied emp name:" + employee.getEmpName());
		this.employeeService.createEmployee(employee);

		return employee;

	}

	@PutMapping(value = "/update")
	public Employee updateOperation(@RequestBody Employee employee) {
		System.out.println("recevied emp no:" + employee.getEmpNo());
		System.out.println("recevied emp name:" + employee.getEmpName());

		// this.employeeDao.updateEmployee(employee);
		return employee;

	}

	@DeleteMapping(value = "/delete")
	public String deleteOperation(@RequestBody Employee employee) {
		System.out.println("recevied emp no:" + employee.getEmpNo());
		System.out.println("recevied emp name:" + employee.getEmpName());

		employee.setEmpName("created jdslkdj");
		System.out.println("recevied emp name:" + employee.getEmpName());
		return "Deleted" + employee.getEmpName();

	}

	@DeleteMapping(value = "/getbyId/{EmpNo}")
	public Employee getEmpbyId(@PathVariable int EmpNo) throws InvalidEmployeeException {
	
		Employee employee = this.employeeService.readEmployeeById(EmpNo);
		return employee;

	}

	@DeleteMapping(value = "/deleteByid/{empNo}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })

	public int deleteByEmployeeId(@PathVariable int empNo) {

		this.employeeService.deleteEmployeeById(empNo);

		return empNo;

	}
	@DeleteMapping(value = "/deleteByName/{empName}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })

	public String deleteByEmployeeName(@PathVariable String empName ) {

		this.employeeService.deleteEmployeeByName(empName);

		return empName;

	}

}
