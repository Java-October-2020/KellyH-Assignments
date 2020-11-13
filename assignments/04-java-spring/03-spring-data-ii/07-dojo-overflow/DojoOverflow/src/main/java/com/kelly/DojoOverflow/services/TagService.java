package com.kelly.DojoOverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelly.DojoOverflow.models.Tag;
import com.kelly.DojoOverflow.repositories.TagRepo;

@Service
public class TagService{
	
	@Autowired
	private TagRepo tRepo;
	
	//create
	public Tag createTag(Tag t) {
		return this.tRepo.save(t);
	}
	//read
	public Tag findOneTag(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	public List<Tag> findAll(){
		return this.tRepo.findAll();
		}
	//update
	public Tag updateTag(Tag t) {
		return this.tRepo.save(t);
	}
	//delete
	public void deleteTag(Long id) {
		this.tRepo.deleteById(id);
	}
}