package com.kelly.Events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelly.Events.models.Event;
import com.kelly.Events.models.Message;
import com.kelly.Events.models.User;
import com.kelly.Events.repositories.EventRepository;

@Service
public class EventService{
	
	@Autowired
	private EventRepository eRepo;
	
	//create
	public Event createEvent(Event e) {
		return eRepo.save(e);
	}
	//read
	public List<Event> findAll() {
		return eRepo.findAll();
	}
	public List<Event> findByState(String state){
		return eRepo.findByState(state);
	}
	public Event findEventById(Long id) {
		return eRepo.findById(id).orElse(null);
	}
	//add user to event (rsvp)
	public void rsvp(User u, Event e) {
		List<User> toRsvp = e.getUsersAttending();
		toRsvp.add(u);
		eRepo.save(e);	
	}
	//remove user to event (Unrsvp)
		public void unRsvp(User u, Event e) {
			List<User> toUnrsvp = e.getUsersAttending();
			toUnrsvp.remove(u);
			eRepo.save(e);	
		}

	//add message to event
		public void addMessage(Message m, Event e) {
			List<Message> eventMessages = e.getEventMessages();
			eventMessages.add(m);
			eRepo.save(e);
		}
	//update
	public Event updateEvent(Event e) {
		return eRepo.save(e);
	}
	//delete
	public void deleteEventById(Long id) {
		eRepo.deleteById(id);
	}
	
	
//	NOT NEEDED	
//	//find all users by event attending
//	public List<User> findUserByEventsAttending(User u){
//		List<User> attending = 
//	}
}
