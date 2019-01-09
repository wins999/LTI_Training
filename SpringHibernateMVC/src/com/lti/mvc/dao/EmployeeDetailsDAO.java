package com.lti.mvc.dao;

import java.util.List;

import com.lti.mvc.model.EmployeeDetails;

public interface EmployeeDetailsDAO {
	
	public void createEmployeeDetails(EmployeeDetails employeeDetails);
	public void updateEmployeeDetails(EmployeeDetails employeeDetails);
	public void deleteEmployeeDetails(int empId);
	public List<EmployeeDetails> getAllEmployeeDetails();
	public EmployeeDetails getEmployeeDetailsById(int empId);	
	public List<EmployeeDetails> getEmployeeDetailsByName(String name);	

}
