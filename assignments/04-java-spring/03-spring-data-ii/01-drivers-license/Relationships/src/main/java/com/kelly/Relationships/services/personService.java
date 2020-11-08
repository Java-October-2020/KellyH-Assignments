package com.kelly.Relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelly.Relationships.models.Person;
import com.kelly.Relationships.repos.personRepo;

@Service 
public class personService{
	@Autowired
	private personRepo pRepo;
	
	//create
	public Person createPerson(Person p) {
		return pRepo.save(p);
	}
	//read all
	public List<Person> findAll(){
		return pRepo.findAll();
	}
	
	//read
	public Person showPerson(Long id) {
		Optional<Person> p = this.pRepo.findById(id);
		if(p.isPresent()) {
			return p.get();
		}
		else {
			return null;
		}
	}
}