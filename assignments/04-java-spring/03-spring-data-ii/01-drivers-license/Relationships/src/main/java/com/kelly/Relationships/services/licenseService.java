package com.kelly.Relationships.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelly.Relationships.models.License;
import com.kelly.Relationships.repos.licenseRepo;

@Service
public class licenseService{
	@Autowired
	private licenseRepo lRepo;
	
	public int generateNumber() {
		License lic = lRepo.findTopByOrderByNumberDesc();
		if (lic == null) {
			return 1;
		}
		else {
			int num = lic.getNumber();
			num ++;
			return num;
		}
	}
	
	//Create
	public License createLicense(License license) {
		license.setNumber(this.generateNumber());
		return this.lRepo.save(license);
	}
	
	
}

