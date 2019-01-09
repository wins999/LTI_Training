package com.lti.mvc.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
public class Department {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String depName;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<EmployeeDetails> employee;

	public Department() {
		super();
	}

	public Department(String depName, Set<EmployeeDetails> employee) {
		super();
		this.depName = depName;
		this.employee = employee;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Set<EmployeeDetails> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<EmployeeDetails> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Department [depId=" + id + ", depName=" + depName + ", employee=" + employee + "]";
	}
	  
	
	
}
