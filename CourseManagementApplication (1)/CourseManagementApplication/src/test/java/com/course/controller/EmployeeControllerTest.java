package com.course.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.course.dto.EnrollDto;
import com.course.dto.EnrollResponseDto;
import com.course.service.EmployeeService;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeControllerTest {
	@InjectMocks
	EmployeeController employeeController;
	
	@Mock
	EmployeeService employeeService;
	
	@Test
	public void testEnrollTraining() {
		EnrollDto enrollDto = new EnrollDto();
		EnrollResponseDto enrollResponseDto = new EnrollResponseDto();
		Mockito.when(employeeService.enrollCourse(enrollDto)).thenReturn(enrollResponseDto);
		Assert.assertNotNull(enrollResponseDto);
		ResponseEntity<EnrollResponseDto> response = employeeController.enrollTraining(enrollDto);
		Assert.assertNotNull(response.getBody());
	}

}
