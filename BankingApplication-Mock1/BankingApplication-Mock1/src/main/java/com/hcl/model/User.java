package com.hcl.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "phone") })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	@Size(min = 3, max = 25, message = "the custometr name is size 3  to 9")
	private String customerName;
	@Past
	@Temporal(TemporalType.DATE)
	private Date DOB;
	private String password;
	private String gender;
	@Size(min = 10, max = 10, message = "the Phone number should have only 10 digits")
	@Column(unique = true)
	private String phone;
	@Column(name = "aadhar_no", unique = true)
	private Long aadharNo;
	@NotEmpty(message = "Occupation Should not be blank")
	private String occupation;
	@NotEmpty(message = "Address Should not be blank")
	private String address;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public User() {
		super();
	}

	public User(Long customerId, String customerName, Date dOB, String password, String gender, String phone,
			Long aadharNo, String occupation, String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		DOB = dOB;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
		this.aadharNo = aadharNo;
		this.occupation = occupation;
		this.address = address;
	}

	public User(Long customerId, String customerName, String password, String gender, String phone, String occupation,
			String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
		this.occupation = occupation;
		this.address = address;
	}

	public User(Long customerId, String password) {
		super();
		this.customerId = customerId;
		this.password = password;
	}


	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [customerId=" + customerId + ", customerName=" + customerName + ", DOB=" + DOB + ", password="
				+ password + ", gender=" + gender + ", phone=" + phone + ", aadharNo=" + aadharNo + ", occupation="
				+ occupation + ", address=" + address + "]";
	}

}
