package com.course.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.course.dto.EnrollDto;
import com.course.dto.EnrollResponseDto;
import com.course.exception.EmployeeNotFoundException;
import com.course.exception.TrainingNotFoundException;
import com.course.model.Employee;
import com.course.model.Training;
import com.course.repository.EmployeeRepository;
import com.course.repository.TrainingRepository;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeServiceTest {
	@InjectMocks
	EmployeeService employeeService;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@Mock
	TrainingRepository trainingRepository;
	
	@Test(expected=EmployeeNotFoundException.class)
	public void testEnrollCoursefoorExcep() {
		EnrollDto enrollDto = new EnrollDto();
		enrollDto.setEmployeeId(1L);
		enrollDto.setTrainingId(100L);
		LocalDate localDate= LocalDate.now();
		EnrollResponseDto enrollResponseDto = new EnrollResponseDto();
		Employee employee = employeeRepository.findById(enrollDto.getEmployeeId()).orElseThrow(()->new EmployeeNotFoundException("employee with given id not found"));
		Training training = trainingRepository.findById(enrollDto.getTrainingId()).orElseThrow(()->new TrainingNotFoundException("training with given id not found"));
		if(training.getStartDate().compareTo(localDate)>0)
		{
			List<Employee> employees = new ArrayList<>();
			employees.add(employee);
			training.setEmployees(employees);
			trainingRepository.save(training);
			BeanUtils.copyProperties(training, enrollResponseDto);
			enrollResponseDto.setCourseName(training.getCourse().getCourseName());
			enrollResponseDto.setMessage("successfully enrolled in "+training.getCourse().getCourseName()+" with batch name "+training.getBatchName());
		}
		else {
			enrollResponseDto.setMessage("enrolling cannot be done as training start date has begun");
		}
	}
	
	@Test(expected=TrainingNotFoundException.class)
	public void testEnrollCourseForExcep() {
		EnrollDto enrollDto = new EnrollDto();
		enrollDto.setEmployeeId(1L);
		enrollDto.setTrainingId(100L);
		LocalDate localDate= LocalDate.now();
		EnrollResponseDto enrollResponseDto = new EnrollResponseDto();
		Employee employee = new Employee();
		employee.setEmail("gs@gmail.com");
		employee.setEmployeeId(1L);
		employee.setEmployeeName("gs");
		employeeRepository.save(employee);
		Training training = trainingRepository.findById(enrollDto.getTrainingId()).orElseThrow(()->new TrainingNotFoundException("training with given id not found"));
		if(training.getStartDate().compareTo(localDate)>0)
		{
			List<Employee> employees = new ArrayList<>();
			employees.add(employee);
			training.setEmployees(employees);
			trainingRepository.save(training);
			BeanUtils.copyProperties(training, enrollResponseDto);
			enrollResponseDto.setCourseName(training.getCourse().getCourseName());
			enrollResponseDto.setMessage("successfully enrolled in "+training.getCourse().getCourseName()+" with batch name "+training.getBatchName());
		}
		else {
			enrollResponseDto.setMessage("enrolling cannot be done as training start date has begun");
		}
	}
	@SuppressWarnings("unused")
	@Test
	public void testEnrollCourse() {
		EnrollDto enrollDto = new EnrollDto();
		enrollDto.setEmployeeId(1L);
		enrollDto.setTrainingId(100L);
		LocalDate localDate= LocalDate.now();
		EnrollResponseDto enrollResponseDto = new EnrollResponseDto();
		Employee employee = new Employee();
		employee.setEmail("gs@gmail.com");
		employee.setEmployeeId(1L);
		employee.setEmployeeName("gs");
		employeeRepository.save(employee);
		Optional<Employee> employee1 = Optional.of(new Employee());
		Mockito.when(employeeRepository.findById(1L))
				.thenReturn(employee1);/*
										 * Assert.assertEquals(employee.getEmployeeId(),
										 * employee1.get().getEmployeeId());
										 */
		/*
		 * Training training =
		 * trainingRepository.findById(enrollDto.getTrainingId()).orElseThrow(()->new
		 * TrainingNotFoundException("training with given id not found"));
		 * if(training.getStartDate().compareTo(localDate)>0) { List<Employee> employees
		 * = new ArrayList<>(); employees.add(employee);
		 * training.setEmployees(employees); trainingRepository.save(training);
		 * BeanUtils.copyProperties(training, enrollResponseDto);
		 * enrollResponseDto.setCourseName(training.getCourse().getCourseName());
		 * enrollResponseDto.setMessage("successfully enrolled in "+training.getCourse()
		 * .getCourseName()+" with batch name "+training.getBatchName()); } else {
		 * enrollResponseDto.
		 * setMessage("enrolling cannot be done as training start date has begun"); }
		 */
	}

}
