package net.maddy.springmvc.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.maddy.springmvc.model.HelloWorld;

@Controller
public class HelloWorldController {
	@RequestMapping("/helloworld")
         public String handler(Model model){
        	HelloWorld helloWorld = new HelloWorld();
        	helloWorld.setMessage("Hello world example using spring mvc 5!!!");
        	helloWorld.setDateTime(LocalDateTime.now().toString());
        	model.addAttribute("helloWorld", helloWorld);
        	return "helloworld";
         }
}
