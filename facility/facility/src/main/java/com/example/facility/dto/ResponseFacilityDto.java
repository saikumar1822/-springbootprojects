package com.example.facility.dto;

public class ResponseFacilityDto {

	private long facilityId;
	private String facilityBranch;
	private String facilityCity;
	private String message;
	public long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(long facilityId) {
		this.facilityId = facilityId;
	}
	public String getFacilityBranch() {
		return facilityBranch;
	}
	public void setFacilityBranch(String facilityBranch) {
		this.facilityBranch = facilityBranch;
	}
	public String getFacilityCity() {
		return facilityCity;
	}
	public void setFacilityCity(String facilityCity) {
		this.facilityCity = facilityCity;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
