package com.diginamic.datajpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginamic.datajpa.entity.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer>{

	Optional<Species> findFirstByCommonName(String commonName);
	
	List<Species> findByLatinNameContainsIgnoreCase(String latinName);
}
