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
	private String common_name;

	@Column(length = 200, nullable = false)
	private String latin_name;
	
	@OneToMany
	@JoinColumn(name = "species_id")
	private List<Animal> animals = new ArrayList<Animal>();

	public String getCommon_name() {
		return common_name;
	}

	public void setCommon_name(String common_name) {
		this.common_name = common_name;
	}

	public String getLatin_name() {
		return latin_name;
	}

	public void setLatin_name(String latin_name) {
		this.latin_name = latin_name;
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
		return "Species [id=" + id + ", common_name=" + common_name + ", latin_name=" + latin_name + "]";
	}
	
}
