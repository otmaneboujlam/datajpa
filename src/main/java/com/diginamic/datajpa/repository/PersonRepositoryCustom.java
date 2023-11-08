package com.diginamic.datajpa.repository;

import com.diginamic.datajpa.entity.Person;

public interface PersonRepositoryCustom {
	
	void deletePersonHasNoAnimal();
	
	void createPersons(Integer nombrePerson);

}
