package com.diginamic.datajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.diginamic.datajpa.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
@Transactional
public class PersonRepositoryTest {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PersonRepository personRepository;
	
	@BeforeEach
	public void initData() {
		em.clear();
		
		Person p1 = new Person();
		p1.setAge(25);
		p1.setFirstname("Lionel");
		p1.setLastname("Messi");
		em.persist(p1);
		
		Person p2 = new Person();
		p2.setAge(26);
		p2.setFirstname("Lionel");
		p2.setLastname("Messi");
		em.persist(p2);
		
		em.flush();
	}
	
	@Test
	public void findByAgeGreaterThanTest() {
		List<Person> result = personRepository.findByAgeGreaterThan(25);
		Assertions.assertEquals(1, result.size());
	}
}
