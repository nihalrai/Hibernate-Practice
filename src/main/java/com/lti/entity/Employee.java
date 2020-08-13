package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee") // optional
public class Employee {

	@Column(name = "psNo")
	@Id
	@GeneratedValue
	private int psno;

	@Column(name = "name") // optional, if not used the variable name will become column name
	private String name;

	@Column(name = "DOJ")
	private LocalDate DOJ;

	@Column(name = "salary")
	private double salary;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="addr_id")
	private Address address;
	
	public Employee() {
		super();
	}

	public Employee(int psno, String name, LocalDate dataOfJoining, double salary) {
		super();
		this.psno = psno;
		this.name = name;
		this.DOJ = dataOfJoining;
		this.salary = salary;
	}

	public int getPsno() {
		return psno;
	}

	public void setPsno(int psno) {
		this.psno = psno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDataOfJoining() {
		return DOJ;
	}

	public void setDataOfJoining(LocalDate dataOfJoining) {
		this.DOJ = dataOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [psno=" + psno + ", name=" + name + ", dataOfJoining=" + DOJ + ", salary=" + salary
				+ "]";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
