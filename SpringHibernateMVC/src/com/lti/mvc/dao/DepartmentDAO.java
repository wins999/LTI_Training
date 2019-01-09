package com.lti.mvc.dao;

import java.util.List;

import com.lti.mvc.model.Department;
import com.lti.mvc.model.EmployeeDetails;

public interface DepartmentDAO {
	
	public void createDepartment(Department department);
	public void updateDepartment(Department department);
	public void deleteDepartment(int depId);
	public List<Department> getAllDepartment();
	public Department getDepartmentById(int depId);	
}
