package com.kelly.Events.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kelly.Events.models.Event;
import com.kelly.Events.models.Message;
import com.kelly.Events.models.State;
import com.kelly.Events.models.User;
import com.kelly.Events.services.EventService;
import com.kelly.Events.services.MessageService;
import com.kelly.Events.services.UserService;

@Controller
public class HomeController{
	@Autowired
	private EventService eServ;
	@Autowired
	private MessageService mServ;
	@Autowired
	private UserService uServ;
	
	@RequestMapping("/events")
	public String home(HttpSession session, Model model, @ModelAttribute("event") Event e) {
		Long uid = (Long)session.getAttribute("user_id");
		User u = uServ.findUserById(uid);
		List<Event> events = eServ.findAll();
		model.addAttribute("events", events);
		model.addAttribute("states", State.states);
		model.addAttribute("user", u);
		return "events.jsp";
	}
	
	@PostMapping("/createEvent")
	public String createEvent(@Valid @ModelAttribute("event") Event e, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "redirect:/events";
		}
		else {
			Long uid = (Long)session.getAttribute("user_id");
			e.setHost(uServ.findUserById(uid));
			eServ.createEvent(e);
			return "redirect:/events";
		}
	}
	@GetMapping("/delete/{id}")
	public String deleteEvent(@PathVariable("id") Long id) {
		eServ.deleteEventById(id);
		return "redirect:/events";
	}
	@GetMapping("/rsvp/{id}")
	public String rsvp(@PathVariable("id") Long id, HttpSession session) {
		Long uid = (Long)session.getAttribute("user_id");
		User user = uServ.findUserById(uid);
		Event event = eServ.findEventById(id);
		eServ.rsvp(user, event);
		return "redirect:/events";
	}
	@GetMapping("/unRsvp/{id}")
	public String unRsvp(@PathVariable("id") Long id, HttpSession session) {
		Long uid = (Long)session.getAttribute("user_id");
		User user = uServ.findUserById(uid);
		Event event = eServ.findEventById(id);
		eServ.unRsvp(user, event);
		return "redirect:/events";
	}
	//show + if creator edit
	@GetMapping("/events/{id}")
	public String showEvent(@PathVariable("id") Long id, HttpSession session, Model model, @ModelAttribute("message") Message m) {
		Event event = eServ.findEventById(id);
		User user = uServ.findUserById((Long)session.getAttribute("user_id"));
		model.addAttribute("user", user);
		model.addAttribute("event", event);
		model.addAttribute("states", State.states);
		model.addAttribute("messages", mServ.findMessagesByEventId(id));
		return "show.jsp";
		
	}
	@PostMapping("/editEvent/{id}")
	public String editEvent(@PathVariable("id") Long id, @Valid @ModelAttribute("event") Event e, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "redirect:/events/" + id;
		}
		else {
			User host = uServ.findUserById((Long)session.getAttribute("user_id"));
			e.setHost(host);
			eServ.updateEvent(e);
			return "redirect:/events";
		}
	}
	@PostMapping("/message/{id}")
	public String postMessage(@PathVariable("id") Long id, @Valid @ModelAttribute("message") Message m, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "redirect:/events/" + id;
		}
		else {
			Event event = eServ.findEventById(id);
			User poster = uServ.findUserById((Long)session.getAttribute("user_id"));
			m.setMsgPoster(poster);
			m.setEvent(event);
			mServ.createMessage(m);
			return "redirect:/events/"+ id;
		}
	}
	
}