package com.kelly.Dojos_Ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelly.Dojos_Ninjas.models.Dojo;
import com.kelly.Dojos_Ninjas.repositories.DojoRepository;

@Service
public class DojoService{
	@Autowired
	private DojoRepository dRepo;
	
	public List<Dojo> findAll(){
		List<Dojo> d = dRepo.findAll();
		return d;
	}
	
	public Dojo createDojo(Dojo d) {
		return dRepo.save(d);
	}
	
	public Dojo getDojo(Long id) {
		Optional<Dojo> d = dRepo.findById(id);
		if (d.isPresent()) {
			return d.get();
		}
		else {
			return null;
		}
	}
}