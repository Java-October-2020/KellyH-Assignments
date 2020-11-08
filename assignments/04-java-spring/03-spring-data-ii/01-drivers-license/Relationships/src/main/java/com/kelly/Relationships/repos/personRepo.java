package com.kelly.Relationships.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kelly.Relationships.models.Person;

public interface personRepo extends CrudRepository<Person, Long>{
	
	List<Person> findAll();
	
}