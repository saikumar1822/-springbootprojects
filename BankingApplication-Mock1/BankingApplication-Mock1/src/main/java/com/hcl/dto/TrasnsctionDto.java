package com.hcl.dto;
public class TrasnsctionDto {
	
	private int id;
	private int accountNumber;
	private Long banificiaryAccountNo;
	private double amount;
	private boolean status;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

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
