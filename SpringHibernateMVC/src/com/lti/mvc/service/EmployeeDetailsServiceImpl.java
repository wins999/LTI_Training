package com.lti.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.mvc.dao.EmployeeDetailsDAO;
import com.lti.mvc.daoIml.EmployeeDetailsImpl;
import com.lti.mvc.model.EmployeeDetails;

@Service
public class EmployeeDetailsServiceImpl implements IEmployeeDetailsSevice{

	EmployeeDetailsDAO employeeDao;	
	
	@Autowired
	public void setEmployeeDao(EmployeeDetailsDAO employeeDao) {
		this.employeeDao = employeeDao;
	}	

	@Override
	@Transactional
	public void createEmployeeDetails(EmployeeDetails employeeDetails) {
		// TODO Auto-generated method stub
		employeeDao.createEmployeeDetails(employeeDetails);
	}



	@Override
	@Transactional
	public void updateEmployeeDetails(EmployeeDetails employeeDetails) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployeeDetails(employeeDetails);
	}

	@Override
	@Transactional
	public void deleteEmployeeDetails(int empId) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployeeDetails(empId);
	}

	@Override
	@Transactional
	public List<EmployeeDetails> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployeeDetails();
	}

	@Override
	@Transactional
	public EmployeeDetails getEmployeeDetailsById(int empId) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeDetailsById(empId);
	}

	@Override
	@Transactional
	public List<EmployeeDetails> getEmployeeDetailsByName(String name) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeDetailsByName(name);
	}

}
