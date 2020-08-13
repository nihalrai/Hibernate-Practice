package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CUST")
public class Customer {
	@Id			//pk --for composite pk will use @EmbeddedId
	@GeneratedValue
	@Column(name = "CUST_ID")
	private int id;
	
	@Column(name = "CUST_NAME")
	private String name;
	
	@Column(name = "CUST_EMAIL", unique=true)
	private String email;
	
	public Customer() {
		super();
	}
	
	public Customer(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
