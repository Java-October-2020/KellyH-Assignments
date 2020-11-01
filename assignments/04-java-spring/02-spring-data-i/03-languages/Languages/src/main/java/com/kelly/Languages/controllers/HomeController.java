package com.kelly.Languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.kelly.Languages.models.Lang;
import com.kelly.Languages.services.LangService;

@Controller
public class HomeController{
	
	private final LangService langService;
	
	public HomeController(LangService langService) {
		this.langService = langService;
	}
	
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("lang") Lang lang) {
		List<Lang> langs = langService.allLangs();
		model.addAttribute("langs", langs);
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String createLangHome(@Valid @ModelAttribute("lang") Lang lang, BindingResult result) {
		if (result.hasErrors()) {
			return "newLang.jsp";
		}
		else {
			langService.createLang(lang);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{index}")
	public String findLangByIndex(Model model, @PathVariable(value="index") Long index) {
		Lang l = langService.findLang(index);
		model.addAttribute("langs",l);
		return "showLangs.jsp";
	}
	
	@RequestMapping("languages/new")
	public String newLang(@ModelAttribute("lang") Lang lang) {
		return "newLang.jsp";
	}
	@PostMapping("languages/new")
	public String createLang(@Valid @ModelAttribute("lang") Lang lang, BindingResult result) {
		if (result.hasErrors()) {
			return "newLang.jsp";
		}
		else {
			langService.createLang(lang);
			return "redirect:/languages";
		}
	}
	@RequestMapping("languages/edit/{index}")
	public String updateLang(@PathVariable("index") Long index, Model model) {
		Lang l = langService.findLang(index);
		if (l != null) {
			model.addAttribute(l);
			return "editLang.jsp";
		}
		else {
			return "redirect:/languages.jsp";
		}
	}
	
	@PostMapping("languages/edit/{index}")
	public String sendUpdate(@PathVariable("index") Long index, @Valid @ModelAttribute("lang") Lang lang, BindingResult result) {
		if (result.hasErrors()) {
			return "editLang.jsp";
		}
		else { 
			String name = lang.getName();
			String creator = lang.getCreator();
			float version = lang.getVersion();
			langService.updateLang(index, name, creator, version);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("languages/delete/{index}")
	public String deleteLang(@PathVariable(value="index") Long index) {
		langService.deleteLang(index);
		return "redirect:/languages";
	}
}