package com.course.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.ResponseEntity;

import com.course.exception.CourseNotFoundException;
import com.course.exception.TrainingsListNotFoundException;
import com.course.model.Course;
import com.course.model.Employee;
import com.course.model.Training;
import com.course.service.EmployeeTrainingService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeTrainingControllerTest {
	
	
		@InjectMocks
		EmployeeTrainingController employeeTrainingController;

		@Mock
		EmployeeTrainingService employeeTrainingService;
		List<Training> traininList=new ArrayList<Training>();
		Training t=new Training();
		Employee e=new Employee();
		
		Course c=new Course();
		List<Employee> employee=new ArrayList<Employee>();
		
		@Test
		public void testGetTrainingListNegative() throws CourseNotFoundException, TrainingsListNotFoundException {
			c.setCourseId(1);
			c.setCourseName("java");
			c.setDescription("good");
			e.setEmployeeId(1l);
			e.setEmployeeName("sai");
			e.setPhone("90484757");
			e.setEmail("sa@gmail.com");
			t.setBatchName("java");
			t.setCourse(c);
			employee.add(e);
			t.setEmployee(employee);
			traininList.add(t);
			Mockito.when(employeeTrainingService.getAll(Mockito.any(String.class))).thenReturn((traininList));
			ResponseEntity<List<Training>> resStudent = employeeTrainingController.getTrainingList("java");
			Assert.assertNotNull(resStudent);
		}

			
	
		@Test(expected = NullPointerException.class)
		public void testGetAllStudentsForExc() throws CourseNotFoundException, TrainingsListNotFoundException {
			Mockito.when(employeeTrainingService.getAll(Mockito.any(String.class))).thenThrow(NullPointerException.class);
			ResponseEntity<List<Training>> resStudent = employeeTrainingController.getTrainingList("java");
		
		}

	}



