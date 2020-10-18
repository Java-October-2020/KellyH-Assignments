package com.kelly.DisplayDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController{
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model dateModel) {
		Date dt = new Date();
		SimpleDateFormat df = new SimpleDateFormat("EEEE, 'the' d 'of' MMMM, yyyy");
		dateModel.addAttribute("ddate", df.format(dt));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model timeModel) {
		Date dt = new Date();
		SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
		timeModel.addAttribute("ttime", df.format(dt));
		return "time.jsp";
	}
	
	
}