package com.course.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.course.model.Course;
import com.course.model.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class TrainingDto {
	private long trainingId;

	private String batchname;

	private LocalDate startDate;

	private LocalDate endDate;
	@ManyToMany
    private List<Employee> employees;
	@JsonIgnore
	@ManyToOne()
	private Course course;

	private String redgStatus;
	public List<Employee> getEmployee() {
		return employees;
	}

	public void setEmployee(List<Employee> employee) {
		this.employees = employee;
	}

	
	public long getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(long trainingId) {
		this.trainingId = trainingId;
	}

	

	public String getBatchname() {
		return batchname;
	}

	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getRedgStatus() {
		return redgStatus;
	}

	public void setRedgStatus(String redgStatus) {
		this.redgStatus = redgStatus;
	}


}
