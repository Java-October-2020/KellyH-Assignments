package com.kelly.Events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelly.Events.models.Message;
import com.kelly.Events.repositories.MessageRepository;

@Service
public class MessageService{
	@Autowired
	private MessageRepository mRepo;
	
	//create
	public Message createMessage(Message m) {
		return mRepo.save(m);
	}
	//read
	public List<Message> findAll(){ // might not need this
		return mRepo.findAll();
	}
	public Message findMessageById(Long id) {
		return mRepo.findById(id).orElse(null);
	}
	public List<Message> findMessagesByEventId(Long id) {
		return mRepo.findAllByEventId(id);
	}
	//update
	public Message updateMessage(Message m) {
		return mRepo.save(m);
	}
	//delete
	public void deleteMessageById(Long id) {
		mRepo.deleteById(id);
	}
}