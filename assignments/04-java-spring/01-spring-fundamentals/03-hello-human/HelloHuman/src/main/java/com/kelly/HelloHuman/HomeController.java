package com.kelly.HelloHuman;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController{
	@RequestMapping("/")
	public String index(@RequestParam(value="q", required=false) String nameQuery, Model names) {
		if (nameQuery != null) {
			names.addAttribute("name", nameQuery);
		}
		else {
			names.addAttribute("name", "human");
		}
		return "index.jsp";
	}
}