package com.lti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_acc")
public class Account { 
	@Id
	private int acno;
	private String name;
	
	@Column(name = "ac_type")
	private String type;
	private double balance;
	
	@OneToMany(mappedBy = "account")
	private List<Transaction> transaction;

	public Account() {
		super();
	}

	public Account(int acNo, String name, String ac_type, double balance, List<Transaction> transaction) {
		super();
		this.acno = acNo;
		this.name = name;
		this.type = ac_type;
		this.balance = balance;
		this.transaction = transaction;
	}

	public int getAcNo() {
		return acno;
	}

	public void setAcNo(int acNo) {
		this.acno = acNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAc_type() {
		return type;
	}

	public void setAc_type(String ac_type) {
		this.type = ac_type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	
}
