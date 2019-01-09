package com.lti.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.mvc.dao.DepartmentDAO;
import com.lti.mvc.model.Department;

@Service
public class DepartmentService implements IDepartmentService{
	
	private DepartmentDAO department;	
	
	@Autowired
	public void setDepartment(DepartmentDAO department) {
		this.department = department;
	}

	@Override
	public void createDepartment(Department department) {
		// TODO Auto-generated method stub
		this.department.createDepartment(department);
	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		this.department.updateDepartment(department);
	}

	@Override
	public void deleteDepartment(int depId) {
		// TODO Auto-generated method stub
		this.department.deleteDepartment(depId);
	}

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return this.department.getAllDepartment();
	}

	@Override
	public Department getDepartmentById(int depId) {
		// TODO Auto-generated method stub
		return this.department.getDepartmentById(depId);
	}
	
	

}
