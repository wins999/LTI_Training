package com.lti.mvc.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.lti.mvc.dao.PersonDAO;
import com.lti.mvc.model.Person;


//@Service
public class PersonServiceImpl implements IPersonService {
	private PersonDAO personDao;
//setter method for personDao
	@Autowired
	public void setPersonDao(PersonDAO personDao) {
		this.personDao = personDao;
	}
	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDao.addPerson(p);
	}
	@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDao.updatePerson(p);
	}
	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDao.listPerson();
	}
	@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDao.ListPersonbyId(id);
	}
	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDao.removePerson(id);
	}	
}
