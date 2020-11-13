package com.kelly.DojoOverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kelly.DojoOverflow.models.Tag;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long> {
	List<Tag> findAll();
	
	Optional<Tag> findTagBySubject(String subject);
	
}