package com.lti.mvc.daoIml;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.mvc.dao.PersonDAO;
import com.lti.mvc.model.Person;

public class PersonDaoImpl implements PersonDAO{
	private static final Logger logger = 			
			LoggerFactory.getLogger(PersonDaoImpl.class);
	
	SessionFactory sessionFactory ;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addPerson(Person p) {
		// TODO Auto-generated method stub
	 Session session = this.sessionFactory.getCurrentSession();
	 session.persist(p);
	logger.info("Person saved successfully, Person Details="+ p);
	}

	@Override
	public void updatePerson(Person p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, "+ "Person Details=" + p);
	}

	@Override
	public List<Person> listPerson() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();
		for (Person p : personsList) {
			logger.info("Person List::" + p);
		}
		return personsList;
	}

	@Override
	public Person ListPersonbyId(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details=" + p);
		return p;
	}

	@Override
	public void removePerson(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Person p = 
		(Person) session.load(Person.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}else {
			logger.error("Person NOT deleted, with person Id=" +id);
		}
		logger.info("Person deleted successfully, person details=" + p);
	}
	
}
