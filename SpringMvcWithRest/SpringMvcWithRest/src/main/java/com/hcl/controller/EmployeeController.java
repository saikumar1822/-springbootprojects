package com.hcl.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Employee;
import com.hcl.service.EmployeeService;

@RestController

@ResponseBody
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	

	@RequestMapping(value = "/addEmployee",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee addEmployee(@RequestBody Employee employee) {

		return employeeService.addEmployee(employee);

	}

	@RequestMapping(value = "/getEmployeeById/{empId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable("empId") Long empId) {
		Employee newEmployee = employeeService.getEmployeeById(empId);
		return newEmployee;

	}

	@RequestMapping(value = "/getAllEmployees",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return employees;

	}

	@RequestMapping(value = "updateEmployee",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping(value = "deleteEmployee")
	public Employee deleteEmployee(@RequestBody Employee employee) {
		return employeeService.deleteEmployee(employee);
	}

	@DeleteMapping(value = "deleteEmployeeById/{empId}")
	public Long deleteEmployeeById(@PathVariable("empId") Long empId) {
		Long newEmployee = employeeService.deleteEmployeeById(empId);
		return newEmployee;
	}

}
