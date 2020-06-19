package com.hcl.SpringDataJpaExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.SpringDataJpaExample.model.EmployeeAttendance;
import com.hcl.SpringDataJpaExample.repository.EmployeeAttendanceRepository;

@Service
public class EmployeeAttendenceService {
	@Autowired
	private EmployeeAttendanceRepository employeeAttendanceRepository;

	public EmployeeAttendance get(int id) {

		return employeeAttendanceRepository.findById(id).get();
	}

	public void save(EmployeeAttendance employeeAttendance) {

		employeeAttendanceRepository.save(employeeAttendance);
	}

	public void delete(int id) {

		employeeAttendanceRepository.deleteById(id);
	}

	public List<EmployeeAttendance> listAll() {

		return employeeAttendanceRepository.findAll();
	}

	public EmployeeAttendance findByEmployeeName(String employeeName) {

		return employeeAttendanceRepository.findByEmployeeName(employeeName);
	}

	public EmployeeAttendance findByEmployeeCode(String employeeCode) {

		return employeeAttendanceRepository.findByemployeeCode(employeeCode);
	}

	public List<EmployeeAttendance> findByEmpNameAndCode(String employeeName, String employeeCode) {

		return employeeAttendanceRepository.findByEmployeeNameAndEmployeeCode(employeeName,
				employeeCode);
	}
	
	public List<EmployeeAttendance> findByEmpNameOrCode(String employeeName, String employeeCode) {

		return employeeAttendanceRepository.findEmployeeAttendanceByEmployeeNameOrEmployeeCode(employeeName, employeeCode);
	}


}
