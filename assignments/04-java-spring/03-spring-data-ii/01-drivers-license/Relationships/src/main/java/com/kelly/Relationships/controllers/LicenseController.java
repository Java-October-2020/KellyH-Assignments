package com.kelly.Relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kelly.Relationships.models.License;
import com.kelly.Relationships.models.Person;
import com.kelly.Relationships.services.licenseService;
import com.kelly.Relationships.services.personService;

@Controller
@RequestMapping("/licenses")
public class LicenseController{
	
	@Autowired
	private licenseService lService;
	@Autowired
	private personService pService;
	
	@RequestMapping("/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> p = pService.findAll();
		model.addAttribute("persons", p);
		return "license.jsp";
	}
	
	@PostMapping("/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/";
		}
		else {
			this.lService.generateNumber();
			this.lService.createLicense(license);
			return "redirect:/persons/new";
		}
	}
}