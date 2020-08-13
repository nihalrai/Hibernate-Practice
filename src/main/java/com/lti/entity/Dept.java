package com.lti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_department")
public class Dept {
	
	@Id
	private int deptno;
	private String name;
	private String location;
	
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER)
	private List<Emp> employees;
	
	public Dept() {
		super();
	}

	public Dept(int deptno, String name, String location, List<Emp> employees) {
		super();
		this.deptno = deptno;
		this.name = name;
		this.location = location;
		this.employees = employees;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Emp> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Emp> employees) {
		this.employees = employees;
	}
}
