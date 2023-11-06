package com.diginamic.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginamic.datajpa.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>{

}
