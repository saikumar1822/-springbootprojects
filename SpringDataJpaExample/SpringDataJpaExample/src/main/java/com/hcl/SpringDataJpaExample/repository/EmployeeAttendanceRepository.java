package com.hcl.SpringDataJpaExample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.SpringDataJpaExample.model.EmployeeAttendance;

public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendance, Integer> {

	public EmployeeAttendance findByEmployeeName(String employeeName);

	public EmployeeAttendance findByemployeeCode(String employeeCode);

	public List<EmployeeAttendance> findByEmployeeNameAndEmployeeCode(String employeeName, String employeeCode);

	public List<EmployeeAttendance> findEmployeeAttendanceByEmployeeNameOrEmployeeCode(String employeeName,
			String employeeCode);

}
