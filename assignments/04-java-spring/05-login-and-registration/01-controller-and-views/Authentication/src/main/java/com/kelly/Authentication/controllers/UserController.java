package com.kelly.Authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kelly.Authentication.models.User;
import com.kelly.Authentication.services.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService uService;
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "regPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	if (result.hasErrors()) {
    		return "redirect:/registration";
    	}
    	else {
    		User u = uService.registerUser(user);
    		session.setAttribute("user_id", u.getId());
    		return "redirect:/home";
    	}
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirAtt) {
//    	if(session.getAttribute("user_id") != null) {
//		return "redirect:/home";
//	}
    	// if the user is authenticated, save their user id in session
    	if (uService.authenticateUser(email, password)) {
    		User user = uService.findUserByEmail(email);
    		model.addAttribute("user", user);
    		session.setAttribute("user_id", user.getId());
    		return "redirect:/home";
    	}

        // else, add error messages and return the login page
    	else {
    		redirAtt.addFlashAttribute("error", "Invalid Credentials");
    		return "redirect:/login";
    	}
    	 
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	if (session.getAttribute("user_id") == null) {
    		return "redirect:/login";
    	}
    	Long uid = (Long)session.getAttribute("user_id");
    	User user = uService.findUserById(uid);
    	model.addAttribute("user", user);
    	return "home.jsp";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
    	session.invalidate();
        // redirect to login page
    	return "redirect:/login";
    }
}