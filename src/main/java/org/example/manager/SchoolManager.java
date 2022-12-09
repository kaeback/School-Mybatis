package org.example.manager;

import org.example.dao.SchoolDao;
import org.example.exception.*;
import org.example.vo.*;

import java.util.*;

public class SchoolManager {
	
	private SchoolDao dao;
	
	public SchoolManager() {
		dao = new SchoolDao();
	}
	
	public Person addPerson(Person p) throws DuplicateSsnException {
		switch (p.getType()) {
			case "STUDENT": dao.addStudent((Student) p); break;
			case "TEACHER": dao.addTeacher((Teacher) p); break;
			case "STAFF": dao.addStaff((Staff) p); break;
		}
		
		return null;
	}
	
	public Person findPerson(String ssn) throws PersonNotFoundException {
		return dao.searchPersonBySsn(ssn);
	}

	public boolean updatePerson(Person p) {
		return dao.updatePerson(p);
	}
	
	public boolean removePerson(String ssn) {
		return false;
	}
	
	public List<Person> getAllPersons() {
		return dao.findAllPersons();
	}
	
}