package com.kelly.TheCode.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController{
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(path="/code", method=RequestMethod.POST)
	public String codeCheck(@RequestParam(value="code") String code, @ModelAttribute("error") String error, RedirectAttributes redirectAttributes) {
		System.out.println(code);
		if (code.equals("bushido")) {
			return "redirect:/success";
		}
		else {
			redirectAttributes.addFlashAttribute("error", "You do not know the way!");
			return "redirect:/";
		}
	}
	
	@RequestMapping("/success")
	public String success() {	
		return "success.jsp";
	}
	
}