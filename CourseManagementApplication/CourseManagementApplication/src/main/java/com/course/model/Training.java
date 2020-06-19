package com.course.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long trainingId;

	@NotEmpty(message = "Batch num is required")
	private String batchName;

	@NotEmpty(message = "start date is required")
	private LocalDate startDate;

	@NotEmpty(message = "end date is required")
	private LocalDate endDate;
	
	@ManyToMany
    private List<Employee> employees;
	private String redgStatus;
	public List<Employee> getEmployee() {
		return employees;
	}

	public void setEmployee(List<Employee> employee) {
		this.employees = employee;
	}

	@JsonIgnore
	@ManyToOne()
	private Course course;

	public long getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(long trainingId) {
		this.trainingId = trainingId;
	}

	

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchname) {
		this.batchName = batchname;
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
