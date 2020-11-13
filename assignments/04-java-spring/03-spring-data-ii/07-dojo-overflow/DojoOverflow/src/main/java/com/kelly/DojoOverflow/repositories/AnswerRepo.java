package com.kelly.DojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kelly.DojoOverflow.models.Answer;

@Repository
public interface AnswerRepo extends CrudRepository<Answer, Long>{
	List<Answer> findAll();
}