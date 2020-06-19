package com.course.dto;

import javax.validation.constraints.NotEmpty;

public class EnrollDto {
	
	@NotEmpty(message="employeeId is required")
	private Long employeeId;
	
	@NotEmpty(message="training id is required")
	private Long trainingId;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(Long trainingId) {
		this.trainingId = trainingId;
	}

}
