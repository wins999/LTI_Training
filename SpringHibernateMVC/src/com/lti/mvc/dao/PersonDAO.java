package com.lti.mvc.dao;

import java.util.List;

import com.lti.mvc.model.Person;

public interface PersonDAO {
	
	 public void addPerson (Person p);
	 public void updatePerson (Person p);
	 public List<Person> listPerson();
	 public Person ListPersonbyId(int id);
	 public void removePerson(int id);
	 
	 

}
