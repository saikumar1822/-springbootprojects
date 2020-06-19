package com.example.googlepay.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Transaction {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionId;
	
	private String toPhone;
	private long amount;
	@Temporal(TemporalType.DATE)
    private Date transactionDate;
	
	@ManyToOne( cascade = CascadeType.MERGE)
	private User user;
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getToPhone() {
		return toPhone;
	}
	public void setToPhone(String toPhone) {
		this.toPhone = toPhone;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
