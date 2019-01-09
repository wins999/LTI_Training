package com.lti.mvc.daoIml;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.mvc.dao.DepartmentDAO;
import com.lti.mvc.model.Department;
import com.lti.mvc.model.EmployeeDetails;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO{
	private static final Logger logger = 			
			LoggerFactory.getLogger(PersonDaoImpl.class);
	
	SessionFactory sessionFactory ;		
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createDepartment(Department department) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(department);
		logger.info("Department details saved successfully, Department Details="+ department);
		
	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(department);
		logger.info("Department updated successfully, "+ "Department Details=" + department);
		
	}

	@Override
	public void deleteDepartment(int depId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Department p = 
		(Department) session.load(Department.class, new Integer( depId));
		if (null != p) {
			session.delete(p);
		}else {
			logger.error("Department NOT deleted, with Department Id=" + depId);
		}
		logger.info("Department deleted successfully, Department details=" + p);
	}
		
	

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Department> personsList = session.createQuery("from Department").list();
		for (Department p : personsList) {
			logger.info("Department List::" + p);
		}
		return personsList;
	}

	@Override
	public Department getDepartmentById(int depId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Department p = (Department) session.load(Department.class, new Integer(depId));
		logger.info("Department loaded successfully, Department details=" + p);
		return p;
	}

}
