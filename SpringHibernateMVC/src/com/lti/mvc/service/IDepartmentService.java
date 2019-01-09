package com.lti.mvc.service;

import java.util.List;

import com.lti.mvc.model.Department;

public interface IDepartmentService {
	
	public void createDepartment(Department department);
	public void updateDepartment(Department department);
	public void deleteDepartment(int depId);
	public List<Department> getAllDepartment();
	public Department getDepartmentById(int depId);	
	
}
