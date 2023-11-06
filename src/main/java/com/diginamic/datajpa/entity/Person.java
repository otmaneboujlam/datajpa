package com.diginamic.datajpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11)
	private Integer id;
	
	@Column(length = 11, columnDefinition = "default NULL")
	private Integer age;
	
	@Column(length = 50, nullable = false)
	private String firstname;
	
	@Column(length = 50, nullable = false)
	private String lastname;

	@ManyToMany
	private List<Animal> animals = new ArrayList<Animal>();
}
