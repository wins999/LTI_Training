package com.lti.mvc.service;

import java.util.List;

import com.lti.mvc.model.EmployeeDetails;

public interface IEmployeeDetailsSevice {
	
	public void createEmployeeDetails(EmployeeDetails employeeDetails);
	public void updateEmployeeDetails(EmployeeDetails employeeDetails);
	public void deleteEmployeeDetails(int empId);
	public List<EmployeeDetails> getAllEmployeeDetails();
	public EmployeeDetails getEmployeeDetailsById(int empId);	
	public List<EmployeeDetails> getEmployeeDetailsByName(String name);	
}
