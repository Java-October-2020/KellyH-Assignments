package com.kelly.Events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kelly.Events.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
	List<Message> findAll();
	//get message by event
	List<Message> findAllByEventId(Long eventId); 
}