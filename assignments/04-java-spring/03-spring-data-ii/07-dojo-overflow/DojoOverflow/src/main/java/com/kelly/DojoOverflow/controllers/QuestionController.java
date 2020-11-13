package com.kelly.DojoOverflow.controllers;

import java.util.List;

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

import com.kelly.DojoOverflow.models.Answer;
import com.kelly.DojoOverflow.models.Question;
import com.kelly.DojoOverflow.models.Tag;
import com.kelly.DojoOverflow.services.AnswerService;
import com.kelly.DojoOverflow.services.QuestionService;

@Controller
@RequestMapping("/questions")
public class QuestionController{
	@Autowired
	private QuestionService qServ;
	@Autowired 
	private AnswerService aServ;

	
	@GetMapping("")
	public String index(Model model, Tag t, Question q) {
		List<Question> allQ = qServ.findAll();
		// List<Tag> tagByQ = //Query for tags in questions
		model.addAttribute("questions", allQ);
		return "index.jsp";
	}
	
	@GetMapping("/new")
	public String newQ(@ModelAttribute("question") Question q) {
		return "newQ.jsp";
	}
	@PostMapping("/new")
	public String addQ(@Valid @ModelAttribute("question") Question q, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/new";
		}
		else {
			this.qServ.createQuestion(q); //constructor with text and list of tags
			return "redirect:/questions";
		}
	}
	@GetMapping("/{id}")
	public String showQ(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
		model.addAttribute("question", this.qServ.findOneQuestion(id));
		return "show.jsp";
	}
	@PostMapping("/{id}")
	public String answerQ(@PathVariable("id") Long id, @Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/questions";
		}
		else {
			answer.setQuestion(this.qServ.findOneQuestion(id));;
			this.aServ.createAnswer(answer);
			return "redirect:/questions";
		}
	}
}