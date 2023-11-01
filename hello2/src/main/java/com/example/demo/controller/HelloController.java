package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "좋은 하루 되세요");
		return "home";
	}
}
