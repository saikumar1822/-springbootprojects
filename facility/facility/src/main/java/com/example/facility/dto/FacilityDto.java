package com.example.facility.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FacilityDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long facilityId;
	private String facilityBranch;
	private String facilityCity;
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
	

}
