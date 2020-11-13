package com.kelly.DojoOverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelly.DojoOverflow.models.Answer;
import com.kelly.DojoOverflow.repositories.AnswerRepo;

@Service
public class AnswerService{
	
	@Autowired
	private AnswerRepo aRepo;
	
	//create
	public Answer createAnswer(Answer a) {
		return aRepo.save(a);
	}
	//read
	public List<Answer> findAll(){
		return aRepo.findAll();
	}
	
	public Answer findOneAnswer(Long id) {
		return aRepo.findById(id).orElse(null);
	}
	//update
	public Answer updateAnswer(Answer a) {
		return aRepo.save(a);
	}
	//delete
	public void deleteAnswer(Long id) {
		aRepo.deleteById(id);
	}
}