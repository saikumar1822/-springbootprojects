package com.example.employee.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseEmployeeDto;
import com.example.employee.dto.SwipeReportDto;
import com.example.employee.exception.NoEmployeeDataFoundException;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public ResponseEmployeeDto saveEmployee(Employee employee) {
		ResponseEmployeeDto employeeDto = new ResponseEmployeeDto();
		Employee employee1;
		if (employee != null) {
			employee1= employeeRepository.save(employee);
			BeanUtils.copyProperties(employee1, employeeDto);
			return employeeDto;
		} else {
			throw new NoEmployeeDataFoundException();
		}

	}
	public EmployeeDto updateEmployee(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		Employee employee1;
		if (employee != null) {
			employee1= employeeRepository.save(employee);
			BeanUtils.copyProperties(employee1, employeeDto);
			return employeeDto;
		} else {
			throw new NoEmployeeDataFoundException();
		}

	}


	public EmployeeDto getEmployee(Long id) {
		EmployeeDto employeeDto=new EmployeeDto();
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new NoEmployeeDataFoundException());
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;
	}

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
	public SwipeReportDto getEmployee1(Long id) {
		SwipeReportDto swipeReportDto=new SwipeReportDto();
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new NoEmployeeDataFoundException());
		Optional<Date> swipeIn=employee.getSwipes().stream().map(p->p.getSwipeIn()).findFirst();
		long swipeOutCount=employee.getSwipes().stream().map(p->p.getSwipeOut()).count();
		Optional<Date> swipeOut=employee.getSwipes().stream().map(p->p.getSwipeOut()).skip(swipeOutCount-1).findFirst();
		long totalHoursPerDay=(swipeOut.get().getTime()-swipeIn.get().getTime())/(60*60*1000);
		BeanUtils.copyProperties(employee, swipeReportDto);
		swipeReportDto.setWrokingHoursPerDay(totalHoursPerDay);
		
		return swipeReportDto;
	}

}




