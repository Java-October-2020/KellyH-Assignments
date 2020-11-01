package com.kelly.Languages.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kelly.Languages.models.Lang;

@Repository
public interface LangRepo extends CrudRepository<Lang, Long>{
	//Find all languages
	List<Lang> findAll();
	
	List<Lang> findByNameContaining(String search);
	
	Long countByNameContaining(String search);
	
	Long deleteByNameStartingWith(String seach);
	
}