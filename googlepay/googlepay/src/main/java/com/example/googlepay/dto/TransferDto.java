package com.example.googlepay.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class TransferDto {
	private String fromPhoneNumber;
	private String toPhoneNumber;
	private int amount;

	public String getFromPhoneNumber() {
		return fromPhoneNumber;
	}

	public void setFromPhoneNumber(String fromPhoneNumber) {
		this.fromPhoneNumber = fromPhoneNumber;
	}

	public String getToPhoneNumber() {
		return toPhoneNumber;
	}

	public void setToPhoneNumber(String toPhoneNumber) {
		this.toPhoneNumber = toPhoneNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
