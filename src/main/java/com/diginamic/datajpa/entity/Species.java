package com.diginamic.datajpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Species {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String commonName;

	@Column(length = 200, nullable = false)
	private String latinName;
	
	@OneToMany
	@JoinColumn(name = "species_id")
	private List<Animal> animals = new ArrayList<Animal>();

	public String getCommon_name() {
		return commonName;
	}

	public void setCommon_name(String commonName) {
		this.commonName = commonName;
	}

	public String getLatin_name() {
		return latinName;
	}

	public void setLatin_name(String latinName) {
		this.latinName = latinName;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Species [id=" + id + ", commonName=" + commonName + ", latinName=" + latinName + "]";
	}
	
}
