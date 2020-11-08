package com.kelly.Dojos_Ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kelly.Dojos_Ninjas.models.Dojo;
import com.kelly.Dojos_Ninjas.models.Ninja;
import com.kelly.Dojos_Ninjas.services.DojoService;
import com.kelly.Dojos_Ninjas.services.NinjaService;

@Controller

public class HomeController{

	@Autowired
	private DojoService dService;
	@Autowired 
	private NinjaService nService;
	
	@RequestMapping("/dojos/new")
	public String dojos(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/";
		}
		else {
			dService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	@RequestMapping("/ninjas/new")
	public String ninjas(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> d = dService.findAll();
		model.addAttribute("dojos", d);
		return "ninjas.jsp";
	}
	@PostMapping("/ninjas/new")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/ninjas/new";
		}
		else {
			nService.createNinja(ninja);
			return "redirect:/dojos/new";
		}
	}
	@RequestMapping("dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		List<Ninja> n = nService.findByDojo(id);
		Dojo d = dService.getDojo(id);
		model.addAttribute("dojo", d);
		//System.out.println(n);
		model.addAttribute("ninjas", n);
		return "showDojo.jsp";
	}
}