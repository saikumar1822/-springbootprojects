package com.course.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long trainingId;

	@NotEmpty(message = "Batch name is required")
	private String batchName;

	@NotEmpty(message = "start date is required")
	private LocalDate startDate;

	@NotEmpty(message = "end date is required")
	private LocalDate endDate;
	
	private String redgStatus;
	
	@ManyToOne()
	@JsonIgnore
	private Course course;
	
	@ManyToMany()
	private List<Employee> employees;

	public long getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(long trainingId) {
		this.trainingId = trainingId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	

}
