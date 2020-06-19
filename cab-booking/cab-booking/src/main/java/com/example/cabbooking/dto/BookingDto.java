package com.example.cabbooking.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BookingDto {
	private Long userId;
	
	private Long cabId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCabId() {
		return cabId;
	}
	public void setCabId(Long cabId) {
		this.cabId = cabId;
	}

}
