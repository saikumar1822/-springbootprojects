package com.example.cabbooking.dto;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class CabDto {
	
	private Long cabId;

	private String cabName;

	private String registrationNumber;

	private String avialbleStatus;

	
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date timeStamp;


	public Long getCabId() {
		return cabId;
	}


	public void setCabId(Long cabId) {
		this.cabId = cabId;
	}


	public String getCabName() {
		return cabName;
	}


	public void setCabName(String cabName) {
		this.cabName = cabName;
	}


	public String getRegistrationNumber() {
		return registrationNumber;
	}


	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}


	public String getAvialbleStatus() {
		return avialbleStatus;
	}


	public void setAvialbleStatus(String avialbleStatus) {
		this.avialbleStatus = avialbleStatus;
	}


	public Date getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	


}
