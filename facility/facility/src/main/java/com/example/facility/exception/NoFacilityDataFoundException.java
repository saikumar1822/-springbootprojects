package com.example.facility.exception;

@SuppressWarnings("serial")
public class NoFacilityDataFoundException extends RuntimeException {
	
	public NoFacilityDataFoundException() {
		super("NoFacilityDataFoundException");
	}

}
