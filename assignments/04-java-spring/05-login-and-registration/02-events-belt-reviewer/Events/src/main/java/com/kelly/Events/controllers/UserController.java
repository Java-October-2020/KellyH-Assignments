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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kelly.Events.models.State;
import com.kelly.Events.models.User;
import com.kelly.Events.services.UserService;

@Controller
@RequestMapping("/")
public class UserController{
	@Autowired
	private UserService uServ;
	//@Autowired
	//private State state;
	
	@RequestMapping("")
	public String login(@ModelAttribute("user") User u, Model model) {
		
		model.addAttribute("states", State.states);
		return "loginPage.jsp";
	}
	@PostMapping("/registration")
	public String regUser(@Valid @ModelAttribute("user") User newUser, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			System.out.println(result.getFieldErrorCount("password"));
			System.out.println(result.getFieldErrorCount("email"));
			System.out.println(result.getFieldErrorCount("confirmPw"));
			//add flash attributes
			return "redirect:/";
		}
		else {
			User u = uServ.registerUser(newUser);
			session.setAttribute("user", u.getId());
			return "redirect:/events";	
		}
	}
	@PostMapping("/login")
	public String loginUser(@ModelAttribute("user") User u, @RequestParam("lEmail") String email, @RequestParam("lPassword") String password, HttpSession session, Model model) {
		if (uServ.authenticateUser(email, password)) {
    		User user = uServ.findUserByEmail(email);
    		model.addAttribute("user", user);
    		session.setAttribute("user_id", user.getId());
    		return "redirect:/events";
    	}

    	else {
    		//redirAtt.addFlashAttribute("error", "Invalid Credentials");
    		return "redirect:/login";
    	}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
        // invalidate session
    	session.invalidate();
        // redirect to login page
    	return "redirect:/";
    }
}