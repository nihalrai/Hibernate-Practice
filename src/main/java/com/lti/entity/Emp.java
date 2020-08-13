package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_employee")
public class Emp {
	
	@Id
	private int empno;
	private String name;
	private double salary;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "deptno")
	private Dept dept;

	public Emp() {
		super();
	}

	public Emp(int empno, String name, double salary, Dept dept) {
		super();
		this.empno = empno;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
