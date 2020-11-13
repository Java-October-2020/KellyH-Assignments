package com.kelly.DojoOverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelly.DojoOverflow.models.Question;
import com.kelly.DojoOverflow.models.Tag;
import com.kelly.DojoOverflow.repositories.QuestionRepo;
import com.kelly.DojoOverflow.repositories.TagRepo;

@Service
public class QuestionService{
	
	@Autowired
	private QuestionRepo qRepo;
	@Autowired
	private TagRepo tRepo;
	
	//create
	public Question createQuestion(Question q) {
		String tags = q.getStringTags(); //get tags as one string
		String[] s = tags.split(", "); //split tags into array
		List<Tag> l = new ArrayList<Tag>(); // new list of tags
		for(int i = 0; i < s.length; i++) { //loop through each item in list and create tag
			Tag t = new Tag();
			if(tRepo.findTagBySubject(s[i]).isEmpty()) {//does this tag already exist?
				t.setSubject(s[i]);
				this.tRepo.save(t);
			}
			
			//add tag to l, set tags.
				t.setSubject(s[i]);
				l.add(t);
				q.setTags(l);
				//System.out.println(q.getTags());
				l.clear();
			}
		return this.qRepo.save(q);
	}
	//read
	public Question findOneQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	public List<Question> findAll(){
		return this.qRepo.findAll();
		}
	//update
	public Question updateQuestion(Question q) {
		return this.qRepo.save(q);
	}
	//delete
	public void deleteQuestion(Long id) {
		this.qRepo.deleteById(id);
	}
	
	//turn to tags
	public List<Tag> turnToTag(String stringTags){
		String[] s = stringTags.split(",");
		List<Tag> l = new ArrayList<Tag>();
		for(int i = 0; i < s.length; i++) {
			Tag t = new Tag();
			t.setSubject(s[i]);
			l.add(t);
		}
		return l;
	}
}	