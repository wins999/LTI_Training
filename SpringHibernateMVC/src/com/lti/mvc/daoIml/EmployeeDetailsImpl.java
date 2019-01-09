package com.lti.mvc.daoIml;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.mvc.dao.EmployeeDetailsDAO;
import com.lti.mvc.model.EmployeeDetails;

@Repository
public class EmployeeDetailsImpl implements EmployeeDetailsDAO{
	private static final Logger logger = 			
			LoggerFactory.getLogger(PersonDaoImpl.class);
	
	SessionFactory sessionFactory ;		
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createEmployeeDetails(EmployeeDetails employeeDetails) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		session.persist(employeeDetails);
		session.close();
		logger.info("Employee details saved successfully, Employee Details="+ employeeDetails);
		
	
	}

	@Override
	public void updateEmployeeDetails(EmployeeDetails employeeDetails) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		session.update(employeeDetails);
		session.close();
		logger.info("Employee details updated successfully, "+ "Employee Details=" + employeeDetails);
	}

	@Override
	public void deleteEmployeeDetails(int empId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		EmployeeDetails p = 
		(EmployeeDetails) session.load(EmployeeDetails.class, new Integer(empId));
		if (null != p) {
			session.delete(p);
		}else {
			logger.error("Employee NOT deleted, with employee Id=" +empId);
		}
		session.close();
		logger.info("Employee deleted successfully, employee details=" + p);
	}

	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<EmployeeDetails> personsList = session.createQuery("from EmployeeDetails").list();
		for (EmployeeDetails p : personsList) {
			logger.info("Employee List::" + p);
		}
		session.close();
		return personsList;
	}

	@Override
	public EmployeeDetails getEmployeeDetailsById(int empId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		EmployeeDetails p = (EmployeeDetails) session.load(EmployeeDetails.class, new Integer(empId));
		logger.info("Employee loaded successfully, Employee details=" + p);
		session.close();
		return p;
	}

	@Override
	public List<EmployeeDetails> getEmployeeDetailsByName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Criteria query = session.createCriteria("from EmployeeDetails");
		query.add(Restrictions.eq("firstName", name));
		List<EmployeeDetails> personsList = query.list();
		for (EmployeeDetails p : personsList) {
			logger.info("Employee List::" + p);
		}
		session.close();
		return personsList;
	}

	

}
