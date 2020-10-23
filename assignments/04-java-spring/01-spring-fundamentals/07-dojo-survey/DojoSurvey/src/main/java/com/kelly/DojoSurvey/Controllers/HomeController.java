package com.kelly.DojoSurvey.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController{
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(path="/submit", method=RequestMethod.POST)
	public String submitForm(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment", required=false) String comment, Model viewModel) {
		System.out.println(comment);
		viewModel.addAttribute("sName", name);
		viewModel.addAttribute("sLanguage", language);
		viewModel.addAttribute("sLocation", location);
		if (comment.isEmpty() == false) {
			viewModel.addAttribute("sComment", comment);
		}
		return "results.jsp";
	}
}