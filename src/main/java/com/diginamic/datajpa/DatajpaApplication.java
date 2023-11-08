package com.diginamic.datajpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.diginamic.datajpa.entity.Animal;
import com.diginamic.datajpa.entity.Person;
import com.diginamic.datajpa.entity.Species;
import com.diginamic.datajpa.repository.AnimalRepository;
import com.diginamic.datajpa.repository.PersonRepository;
import com.diginamic.datajpa.repository.SpeciesRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class DatajpaApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private SpeciesRepository speciesRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DatajpaApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		System.out.println("--------------------");
		System.out.println(personRepository.count());
		System.out.println(animalRepository.count());
		System.out.println(speciesRepository.count());
		
		Species s = new Species();
		s.setCommon_name("Rat");
		s.setLatin_name("Rattus");
		speciesRepository.save(s);
		
		Animal a = new Animal();
		a.setColor("Noir");
		a.setName("Gus");
		a.setSex("M");
		a.setSpecies(s);
		animalRepository.save(a);
		
		Person p = new Person();
		p.setAge(25);
		p.setFirstname("Lionel");
		p.setLastname("Messi");
		p.getAnimals().add(a);
		personRepository.save(p);
		
		System.out.println("--------------------");
		System.out.println(personRepository.count());
		System.out.println(animalRepository.count());
		System.out.println(speciesRepository.count());
		
		System.out.println("--------------------");
		for(Person person : personRepository.findAll()) {
			System.out.println(person.toString());
			if(person.getAnimals() != null)
				for(Animal animalPerson : person.getAnimals()) {
					System.out.println(animalPerson.toString());
				}
		}
		
		System.out.println("--------------------");
		for(Animal animal : animalRepository.findAll()) {
			System.out.println(animal.toString());
			if(animal.getPersons() != null)
				for(Person personAnimal : animal.getPersons()) {
					System.out.println(personAnimal.toString());
				}
		}

		System.out.println("--------------------");
		for(Species specie : speciesRepository.findAll()) {
			System.out.println(specie.toString());
			if(specie.getAnimals() != null)
				for(Animal animalSpecie : specie.getAnimals()) {
					System.out.println(animalSpecie.toString());
				}
		}
		
		System.out.println("--------------------");		
		Optional<Person> p1 = personRepository.findById(22);
		if(p1.isPresent()) {
			System.out.println(p1.get().toString());
		}
		else {
			System.out.println("No match found");
		}
		
		System.out.println("--------------------");
		Optional<Animal> a1 = animalRepository.findById(100);
		if(a1.isPresent()) {
			System.out.println(a1.get().toString());
		}
		else {
			System.out.println("No match found");
		}
		
		personRepository.deleteById(9);
		animalRepository.deleteById(6);
		
		//On ne peut pas supprimer une specie qui est attachée à un animal !
		//speciesRepository.deleteById(1);
		
		System.out.println("--------------------");
		System.out.println(personRepository.count());
		System.out.println(animalRepository.count());
		System.out.println(speciesRepository.count());
		
		System.out.println("--------------------");
		Optional<Species> s3 = speciesRepository.findFirstByCommonName("Rat");
		if(s3.isPresent()) {
			System.out.println(s3.get().toString());
		}
		else {
			System.out.println("No match found");
		}
		
		System.out.println("--------------------");
		List<Species> speciesList = speciesRepository.findByLatinNameContainsIgnoreCase("Rat");
		if(speciesList != null) {
			for(Species sp : speciesList)
				System.out.println(sp.toString());
		}
		else {
			System.out.println("No match found");
		}
		
		System.out.println("--------------------");
		List<Person> personList = personRepository.findByFirstnameOrLastname("Bill", "Lamarque");
		if(personList != null) {
			for(Person pp : personList)
				System.out.println(pp.toString());
		}
		else {
			System.out.println("No match found");
		}
		
		System.out.println("--------------------");
		List<Person> personAgeList = personRepository.findByAgeGreaterThan(18);
		if(personAgeList != null) {
			for(Person ppp : personAgeList)
				System.out.println(ppp.toString());
		}
		else {
			System.out.println("No match found");
		}
		
		System.out.println("--------------------");
		List<Animal> animalSpeciesList = animalRepository.findBySpecies(s);
		if(animalSpeciesList != null) {
			for(Animal aa : animalSpeciesList)
				System.out.println(aa.toString());
		}
		else {
			System.out.println("No match found");
		}
		
		System.out.println("--------------------");
		List<String> colors = new ArrayList<>();
		colors.add("Noir");
		colors.add("Blanc");
		List<Animal> animalColorList = animalRepository.findByColorIn(colors);
		if(animalColorList != null) {
			for(Animal ac : animalColorList)
				System.out.println(ac.toString());
		}
		else {
			System.out.println("No match found");
		}
		
		System.out.println("--------------------");
		List<Species> speciesListAsc = speciesRepository.findAllAsc(Sort.by("commonName"));
		if(speciesListAsc != null) {
			for(Species ssa : speciesListAsc)
				System.out.println(ssa.toString());
		}
		else {
			System.out.println("No match found");
		}
		
		System.out.println("--------------------");
		List<Species> speciesListLike = speciesRepository.findAllLike("%Rat%");
		if(speciesListLike != null) {
			for(Species ssl : speciesListLike)
				System.out.println(ssl.toString());
		}
		else {
			System.out.println("No match found");
		}
		
		System.out.println("--------------------");
		List<Person> personAgeInList = personRepository.findAllByAgeIn(18, 40);
		if(personAgeInList != null) {
			for(Person pai : personAgeInList)
				System.out.println(pai.toString());
		}
		else {
			System.out.println("No match found");
		}
		
		System.out.println("--------------------");
		List<Person> personAnimalList = personRepository.findAllByAnimal(a);
		if(personAnimalList != null) {
			for(Person pa : personAnimalList)
				System.out.println(pa.toString());
		}
		else {
			System.out.println("No match found");
		}
		
		System.out.println("--------------------");
		Optional<Integer> countAnimalSex = animalRepository.countAnimalBySex("M");
		if(countAnimalSex.isPresent()) {
			System.out.println(countAnimalSex.get());
		}
		else {
			System.out.println("No match found");
		}
		
		System.out.println("--------------------");
		System.out.println(animalRepository.hasOwner(a));
		
		Animal aaa = new Animal();
		aaa.setColor("Noir");
		aaa.setName("Gus");
		aaa.setSex("M");
		aaa.setSpecies(s);
		animalRepository.save(aaa);
		
		System.out.println(animalRepository.hasOwner(aaa));
		
		System.out.println("--------------------");
		
		personRepository.deletePersonHasNoAnimal();
		
		personRepository.createPersons(2);
		
	}
}
