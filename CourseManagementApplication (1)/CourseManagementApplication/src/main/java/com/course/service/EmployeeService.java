package com.course.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dto.EnrollDto;
import com.course.dto.EnrollResponseDto;
import com.course.exception.EmployeeNotFoundException;
import com.course.exception.TrainingNotFoundException;
import com.course.model.Employee;
import com.course.model.Training;
import com.course.repository.EmployeeRepository;
import com.course.repository.TrainingRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	TrainingRepository trainingRepository;
	
	public EnrollResponseDto enrollCourse(EnrollDto enrollDto) {
		LocalDate localDate= LocalDate.now();
		EnrollResponseDto enrollResponseDto = new EnrollResponseDto();
		Employee employee = employeeRepository.findById(enrollDto.getEmployeeId()).orElseThrow(()->new EmployeeNotFoundException("employee with given id not found"));
		Training training = trainingRepository.findById(enrollDto.getTrainingId()).orElseThrow(()->new TrainingNotFoundException("training with given id not found"));
		if(training.getStartDate().compareTo(localDate)>0)
		{
			List<Employee> employees = null;
			employees.add(employee);
			
			/*
			 * Employee employee1 = new Employee(); employee1.setEmployeeId(102L);
			 * employees.add(employee1);
			 */
			training.setEmployees(employees);
			trainingRepository.save(training);
			BeanUtils.copyProperties(training, enrollResponseDto);
			enrollResponseDto.setCourseName(training.getCourse().getCourseName());
			enrollResponseDto.setMessage("successfully enrolled in "+training.getCourse().getCourseName()+" with batch name "+training.getBatchName());
		}
		else {
			enrollResponseDto.setMessage("enrolling cannot be done as training start date has begun");
		}
		return enrollResponseDto;
	}
}
