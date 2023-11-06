package com.diginamic.datajpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diginamic.datajpa.repository.AnimalRepository;
import com.diginamic.datajpa.repository.PersonRepository;

@SpringBootApplication
public class DatajpaApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository personRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DatajpaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(personRepository.count());
//		
//		PersonneSimple p1 = new PersonneSimple();
//		p1.setNom("BOUJLAM");
//		p1.setPrenom("Otmane");
//		
//		PersonneSimple p2 = new PersonneSimple();
//		p2.setNom("FRIZET");
//		p2.setPrenom("Claire");
//		
//		personneSimpleRepository.save(p1);
//		personneSimpleRepository.save(p2);
//		
//		System.out.println(personneSimpleRepository.count());
//		
//		for(PersonneSimple p : personneSimpleRepository.findAll()) {
//			System.out.println("Id : "+p.getId()+", Nom : "+p.getNom()+", Prenom : "+p.getPrenom());
//		}
//		
//		Optional<PersonneSimple> p3 = personneSimpleRepository.findById(2L);
//		
//		System.out.println("-- Find By Id --");
//		if(p3.isPresent()) {
//			System.out.println("Id : "+p3.get().getId()+", Nom : "+p3.get().getNom()+", Prenom : "+p3.get().getPrenom());
//		}
//		else {
//			System.out.println("No match found");
//		}
//		
//		personneSimpleRepository.deleteById(2L);
//		
//		System.out.println(personneSimpleRepository.count());
	}
}
