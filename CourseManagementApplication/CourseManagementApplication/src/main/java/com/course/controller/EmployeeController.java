package com.course.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.dto.EnrollDto;
import com.course.dto.EnrollResponseDto;
import com.course.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/enroll")
	public ResponseEntity<EnrollResponseDto> enrollTraining(@RequestBody@Valid EnrollDto enrollDto){
		EnrollResponseDto enrollResponseDto = employeeService.enrollCourse(enrollDto);
		return new ResponseEntity<>(enrollResponseDto,HttpStatus.OK);
	}
	

}
