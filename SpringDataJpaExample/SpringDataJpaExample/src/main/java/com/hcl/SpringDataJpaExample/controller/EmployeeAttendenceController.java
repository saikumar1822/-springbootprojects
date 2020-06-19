package com.hcl.SpringDataJpaExample.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.SpringDataJpaExample.model.EmployeeAttendance;
import com.hcl.SpringDataJpaExample.service.EmployeeAttendenceService;

@RestController
public class EmployeeAttendenceController {
	@Autowired
	private EmployeeAttendenceService employeeAttendenceService;

	@GetMapping("welcome1")
	private String method1() {
		return "welcome to spring boot appliction";
	}

	@GetMapping("employeeAttendance/{id}")
	private EmployeeAttendance getEmployeeAttendance(@PathVariable int id) {
		return employeeAttendenceService.get(id);
	}

	@PostMapping("employeeAttendance")
	private int saveEmployeeAttendance(@RequestBody EmployeeAttendance employeeAttendance) {
		employeeAttendenceService.save(employeeAttendance);
		return employeeAttendance.getId();
	}

	@PutMapping("employeeAttendance")
	private long UpdateEmployeeAttendance(@RequestBody EmployeeAttendance employeeAttendance) {
		employeeAttendenceService.save(employeeAttendance);
		return employeeAttendance.getId();
	}

	@DeleteMapping("employeeAttendance/{id}")
	private int deleteEmployeeAttendance(@PathVariable int id) {
		employeeAttendenceService.delete(id);
		return id;
	}

	@GetMapping("employeeAttendanceses")
	private List<EmployeeAttendance> getAllEmployee() {
		return employeeAttendenceService.listAll();
	}

	@GetMapping("employeeAttendance1/{employeeName}")
	private EmployeeAttendance getEmployeeByName(@PathVariable String employeeName) {
		return employeeAttendenceService.findByEmployeeName(employeeName);
	}

	@GetMapping("employeeAttendance2/{employeeCode}")
	private EmployeeAttendance getEmployeeByEmpId(@PathVariable String employeeCode) {
		return employeeAttendenceService.findByEmployeeCode(employeeCode);
	}

	@GetMapping("employeeAttendance3/{employeeName}/{employeeCode}")
	private List<EmployeeAttendance> getEmployeeByNameAndCode(@PathVariable String employeeName,
			@PathVariable String employeeCode) {
		return employeeAttendenceService.findByEmpNameAndCode(employeeName, employeeCode);
	}

	@GetMapping("employeeAttendance4/{employeeName}/{employeeCode}")
	private List<EmployeeAttendance> getEmployeeByNameOrCode(@PathVariable String employeeName,
			@PathVariable String employeeCode) {
		return employeeAttendenceService.findByEmpNameOrCode(employeeName, employeeCode);
	}
}
