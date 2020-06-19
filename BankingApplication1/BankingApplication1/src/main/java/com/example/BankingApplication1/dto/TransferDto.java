package com.example.BankingApplication1.dto;

public class TransferDto {
	private long accountNumber;
	private long beneficiaryAccountNumber;
	private long amount;
	private long customerId;
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}
	public void setBeneficiaryAccountNumber(long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	

}
