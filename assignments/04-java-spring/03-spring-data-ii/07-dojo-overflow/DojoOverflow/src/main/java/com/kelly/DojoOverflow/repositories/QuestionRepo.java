package com.kelly.DojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kelly.DojoOverflow.models.Question;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Long>{

		List<Question> findAll();
}