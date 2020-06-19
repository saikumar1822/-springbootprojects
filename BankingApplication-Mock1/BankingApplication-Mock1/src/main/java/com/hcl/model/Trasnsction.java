package com.hcl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Trasnsction {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int accountNumber;
	private Long banificiaryAccountNo;
	private double amount;
	private boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getBanificiaryAccountNo() {
		return banificiaryAccountNo;
	}

	public void setBanificiaryAccountNo(Long banificiaryAccountNo) {
		this.banificiaryAccountNo = banificiaryAccountNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Trasnsction [id=" + id + ", accountNumber=" + accountNumber + ", banificiaryAccountNo="
				+ banificiaryAccountNo + ", amount=" + amount + ", status=" + status + "]";
	}
	
	

}
