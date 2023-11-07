package com.diginamic.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginamic.datajpa.entity.Animal;
import com.diginamic.datajpa.entity.Species;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>{
	
	List<Animal> findBySpecies(Species species);
	
	List<Animal> findByColorIn(List<String> colors);
	
}
