package com.kelly.Relationships.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kelly.Relationships.models.License;
import com.kelly.Relationships.models.Person;
import com.kelly.Relationships.services.personService;

@Controller
@RequestMapping("/persons")
public class PersonController{
	
	@Autowired
	private personService pService;
	
	@RequestMapping("/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		Person p = pService.showPerson(id);
		License l = p.getLicense();
		System.out.println(l.getId().toString());
		model.addAttribute("person", p);
		model.addAttribute("license", l);
		return "showPerson.jsp";
	}
	
	@RequestMapping("/new")	
	public String newPerson(@ModelAttribute("person") Person person) {
		return "person.jsp";
	}
	
	
	@PostMapping("/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "reidrect:/new";
		}
		else {
			pService.createPerson(person);
			return "person.jsp";
		}
	}
}