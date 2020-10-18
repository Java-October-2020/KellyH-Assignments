package com.kelly.counter;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		Integer currentCount = (Integer) session.getAttribute("count");

		
		currentCount++;
		session.setAttribute("count", currentCount);
		
		System.out.println(currentCount);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counterPage(HttpSession session, Model viewCount) {
		System.out.println(session.getAttribute("count"));
		Integer currentCount = (Integer) session.getAttribute("count");
		viewCount.addAttribute("counter", currentCount);
		return "counter.jsp";
	}
}