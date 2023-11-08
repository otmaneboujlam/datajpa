package com.diginamic.datajpa.repository;

import java.util.List;

import com.diginamic.datajpa.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void deletePersonHasNoAnimal() {

		List<Person> results = em.createQuery("from Person p where p.animals is empty", Person.class).getResultList();
		for(Person person : results) {
			em.remove(person);
		}	
	}

	@Override
	public void createPersons(Integer nombrePerson) {
		
		for(int i=0; i<nombrePerson; i++) {
			Person p = new Person();
			p.setFirstname("First_"+i);
			p.setLastname("Last_"+i);
			p.setAge(i+10);
			em.persist(p);
		}
		
	}

}
