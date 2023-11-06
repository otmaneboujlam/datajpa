package com.diginamic.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginamic.datajpa.entity.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer>{

}
