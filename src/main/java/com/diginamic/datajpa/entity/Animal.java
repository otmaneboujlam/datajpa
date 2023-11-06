package com.diginamic.datajpa.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11)
	private Integer id;
	
	@Column(length = 50, columnDefinition = "default NULL")
	private String color;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 255, nullable = false)
	private String sex;
	
	@ManyToOne
	private Species species;
	
	@ManyToMany(mappedBy = "animals")
	private List<Person> persons;
}
