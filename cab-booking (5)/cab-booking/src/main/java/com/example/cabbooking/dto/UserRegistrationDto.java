package com.example.cabbooking.dto;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

public class UserRegistrationDto {
	@Id
@NotNull
	private String email;
	@JsonIgnore
	private String password;

	private String firstname;
	
	private String lastname;

	private String phoneNumber;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}