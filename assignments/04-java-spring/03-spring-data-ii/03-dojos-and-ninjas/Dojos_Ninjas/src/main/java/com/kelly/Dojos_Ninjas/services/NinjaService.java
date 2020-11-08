package com.kelly.Dojos_Ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelly.Dojos_Ninjas.models.Ninja;
import com.kelly.Dojos_Ninjas.repositories.NinjaRepository;

@Service
public class NinjaService{
	@Autowired
	private NinjaRepository nRepo;
	
	
	public Ninja createNinja(Ninja n) {
		return nRepo.save(n);
	}
	
	public List<Ninja> findByDojo(Long dojoId){
		return nRepo.findByDojoId(dojoId);
	}
	
	public Ninja getNinja(Long id) {
		Optional<Ninja> n = nRepo.findById(id);
		if (n.isPresent()) {
			return n.get();
		}
		else {
			return null;
		}
	}
}