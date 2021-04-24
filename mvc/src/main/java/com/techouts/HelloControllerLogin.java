package com.techouts;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControllerLogin {
	@RequestMapping("/hellologin")
	public String display(HttpServletRequest request, Model model) {
		// read the provided form of data
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		if (password.equals("admin")) {
			String mesage1 = "Hello " + name;
			// add message to the model
			model.addAttribute("message1", mesage1);
			return "loginpage";
		} else {
			String mesage2 = "Sorry " + name + ". You entered an incorrect password";
			model.addAttribute("message2", mesage2);
			return "errorpage";
		}
	}
}
