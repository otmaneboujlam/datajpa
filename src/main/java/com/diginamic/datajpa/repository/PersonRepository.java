package com.diginamic.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginamic.datajpa.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
