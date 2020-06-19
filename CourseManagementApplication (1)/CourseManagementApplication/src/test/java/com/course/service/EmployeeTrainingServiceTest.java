package com.course.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.course.exception.CourseNotFoundException;
import com.course.exception.TrainingsListNotFoundException;
import com.course.model.Course;
import com.course.model.Employee;
import com.course.model.Training;
import com.course.repository.CourseRepository;
import com.course.repository.EmployeeTrainingRepository;

import junit.framework.Assert;
@SuppressWarnings({ "unused", "deprecation" })
@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeTrainingServiceTest {
	@InjectMocks
	EmployeeTrainingService employeeTrainingService;
	
	@Mock
EmployeeTrainingRepository employeeTrainingRepository ;
	
	@Mock
	CourseRepository courseRepository;
	
	List<Training> traininList=new ArrayList<Training>();
	Training t=new Training();
	Employee e=new Employee();
	
	Course c=new Course();
	List<Employee> employee=new ArrayList<Employee>();
	
	@Test
	public void testGetTrainingListPositive() throws CourseNotFoundException, TrainingsListNotFoundException {
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
		t.setEmployees(employee);
		traininList.add(t);
		
		Mockito.when(employeeTrainingRepository.findByCourse(c)).thenReturn((traininList));
		Mockito.when(courseRepository.findByCourseName("java")).thenReturn((c));
		if(c==null) {
			throw new CourseNotFoundException("course not found");
		}
		List<Training> resStudent = employeeTrainingService.getAll("java");
		if(resStudent.isEmpty()) {
			throw new TrainingsListNotFoundException("hfhhg");
		}
	}
	
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
		t.setEmployees(employee);
		traininList.add(t);
		
		Mockito.when(employeeTrainingRepository.findByCourse(Mockito.any(Course.class))).thenReturn((traininList));
		Mockito.when(courseRepository.findByCourseName(Mockito.any(String.class))).thenReturn((c));
		if(c==null) {
			throw new CourseNotFoundException("course not found");
		}
		List<Training> resStudent = employeeTrainingService.getAll("java");
		if(resStudent.isEmpty()) {
			throw new TrainingsListNotFoundException("hfhhg");
		}
	}


		

	@Test(expected = NullPointerException.class)
	public void testGetAllStudentsForExc() throws CourseNotFoundException, TrainingsListNotFoundException {
		Mockito.when(employeeTrainingRepository.findByCourse(Mockito.any(Course.class))).thenThrow(NullPointerException.class);
		
		Mockito.when(employeeTrainingRepository.findByCourse(c)).thenReturn((traininList));
		List<Training> resStudent = employeeTrainingService.getAll("java");
	}

}




