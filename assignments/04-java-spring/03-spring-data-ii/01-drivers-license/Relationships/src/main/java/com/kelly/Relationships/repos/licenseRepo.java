package com.kelly.Relationships.repos;

import org.springframework.data.repository.CrudRepository;

import com.kelly.Relationships.models.License;

public interface licenseRepo extends CrudRepository<License, Long>{

	License findTopByOrderByNumberDesc();
	
	
}