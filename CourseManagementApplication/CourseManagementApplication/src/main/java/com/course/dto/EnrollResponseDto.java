package com.course.dto;

import java.time.LocalDate;

public class EnrollResponseDto {
	private Long trainingId;
	private String batchName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String courseName;
	private String message;
	public Long getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(Long trainingId) {
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
