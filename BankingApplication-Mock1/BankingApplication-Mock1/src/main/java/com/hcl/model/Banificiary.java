package com.hcl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Banificiary {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private Long banificiaryAccountNo;
	private double balance;
	private String  banificiaryName;
	@JsonIgnoreProperties("banificiary")
	@ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBanificiaryAccountNo() {
		return banificiaryAccountNo;
	}

	public void setBanificiaryAccountNo(Long banificiaryAccountNo) {
		this.banificiaryAccountNo = banificiaryAccountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBanificiaryName() {
		return banificiaryName;
	}

	public void setBanificiaryName(String banificiaryName) {
		this.banificiaryName = banificiaryName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}