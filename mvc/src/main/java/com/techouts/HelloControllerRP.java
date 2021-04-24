package com.techouts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloControllerRP {
    @RequestMapping("/hellorp")
	public String display(@RequestParam("name") String name, @RequestParam("pass") String password, Model model) {
		if (password.equals("admin")) {
			String message = "Hello " + name;
			model.addAttribute("data", message);
			return "loginpagerp";
		} else {
			String message = "Sorry " + name + " you entered incorrect password";
			model.addAttribute("data", message);
			return "errorpagerp";
		}
	}
}
