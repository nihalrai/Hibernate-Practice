package com.lti.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_transaction")
public class Transaction {
	
	@Id
	@GeneratedValue
	private int txno;
	
	@Column(name = "date_and_time")
	private LocalDateTime dataAndTime;
	
	
	private double amount;
	
	@Column(name = "tx_type")
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "acno")
	private Account account;

	public Transaction() {
		super();
	}

	public Transaction(int txNo, LocalDateTime dataAndTime, double amount, String tx_type, Account account) {
		super();
		this.txno = txNo;
		this.dataAndTime = dataAndTime;
		this.amount = amount;
		this.type = tx_type;
		this.account = account;
	}

	public int getTxNo() {
		return txno;
	}

	public void setTxNo(int txNo) {
		this.txno = txNo;
	}

	public LocalDateTime getDataAndTime() {
		return dataAndTime;
	}

	public void setDataAndTime(LocalDateTime dataAndTime) {
		this.dataAndTime = dataAndTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTx_type() {
		return type;
	}

	public void setTx_type(String tx_type) {
		this.type = tx_type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
