package com.kelly.RoutingAssignment.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("/dojo")
	public String dojoMain() {
		return "the dojo is aweosme!";
	}
	
	@RequestMapping("/dojo/{location}")
	public String dojo(@PathVariable("location") String place) {
		if (place.equals("burbank")) {
		return "Burbank Dojo is located in Southern California";
		}
		else if (place.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		}
		else {
			return "invalid path variable";
		}
	}
}
