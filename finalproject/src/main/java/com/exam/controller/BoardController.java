package com.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public String list(){
		return "/board/list";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/board/write";
	}
	
	@GetMapping("/read")
	public String read() {
		return null;
	}
	
	@GetMapping("/delete")
	public String delete() {
		return null;
	}
}
