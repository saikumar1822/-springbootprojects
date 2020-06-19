package com.hcl.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="transfer")
public class Tranfer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String phoneNo;
	private String toPhoneNo;
	private double amount;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getToPhoneNo() {
		return toPhoneNo;
	}

	public void setToPhoneNo(String toPhoneNo) {
		this.toPhoneNo = toPhoneNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


}
