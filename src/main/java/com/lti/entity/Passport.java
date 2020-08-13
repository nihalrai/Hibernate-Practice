package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Passport")
public class Passport {
	@Id
	private String passportNo;
	private LocalDate issue_date;
	private LocalDate expiry_date;
	private String city;
	
	@OneToOne
	@JoinColumn(name="person_id")
	private Person person;

	public Passport() {
		super();
	}

	public Passport(String passportNo, LocalDate issue_date, LocalDate expiry_date, String city, Person person) {
		super();
		this.passportNo = passportNo;
		this.issue_date = issue_date;
		this.expiry_date = expiry_date;
		this.city = city;
		this.person = person;
	}
	
	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public LocalDate getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(LocalDate issue_date) {
		this.issue_date = issue_date;
	}

	public LocalDate getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(LocalDate expiry_date) {
		this.expiry_date = expiry_date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
