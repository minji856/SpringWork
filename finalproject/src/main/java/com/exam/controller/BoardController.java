package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.domain.Board;

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
	
//	메서드 이름이 같아도 요청방식이 다르다
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) {
		//// System.out.println(board.getbContent()); 값을 잘 가져오는지 확인. 굳이 test 코드 X
		return null;
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
