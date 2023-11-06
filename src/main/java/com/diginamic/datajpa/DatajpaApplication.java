package com.diginamic.datajpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diginamic.datajpa.entity.Animal;
import com.diginamic.datajpa.entity.Person;
import com.diginamic.datajpa.entity.Species;
import com.diginamic.datajpa.repository.AnimalRepository;
import com.diginamic.datajpa.repository.PersonRepository;
import com.diginamic.datajpa.repository.SpeciesRepository;

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
	public void run(String... args) throws Exception {
		
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
		
		System.out.println(personRepository.count());
		System.out.println(animalRepository.count());
		System.out.println(speciesRepository.count());
		
		for(Person person : personRepository.findAll()) {
			System.out.println(person.toString());
		}
		
		for(Animal animal : animalRepository.findAll()) {
			System.out.println(animal.toString());
		}

		for(Species specie : speciesRepository.findAll()) {
			System.out.println(specie.toString());
		}
				
		Optional<Person> p1 = personRepository.findById(2);
		if(p1.isPresent()) {
			System.out.println(p1.toString());
		}
		else {
			System.out.println("No match found");
		}
		
		Optional<Animal> a1 = animalRepository.findById(100);
		if(a1.isPresent()) {
			System.out.println(a1.toString());
		}
		else {
			System.out.println("No match found");
		}
		
		personRepository.deleteById(2);
		animalRepository.deleteById(100);
		
		System.out.println(personRepository.count());
		System.out.println(animalRepository.count());
		System.out.println(speciesRepository.count());
		
	}
}
