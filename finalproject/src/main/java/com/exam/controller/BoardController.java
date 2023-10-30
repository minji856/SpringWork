package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.domain.Board;
import com.exam.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public ModelAndView list() throws Exception{
		List<Board> list = boardService.getList();
		
		ModelAndView mv = new ModelAndView("/board/list");
		mv.addObject("list", list);
		return mv;
	}
	
//	@GetMapping("/list") 이렇게도 할 수 있다
//	public void list(Model model) throws Exception{
//		List<Board> list = boardService.getList();
//		model.addAttribute(list);
//	}
	
	@GetMapping("/write")
	public String write() {
		return "/board/write";
	}
	
//	메서드 이름이 같아도 요청방식이 다르다
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) throws Exception {
		//// System.out.println(board.getbContent()); 값을 잘 가져오는지 확인. 굳이 test 코드 X
		boardService.write(board);
		return "redirect:/board/list"; // sendredirect랑 똑같은 거
	}
	
//	페이지를 명시 안해줘도 알아서 read.jsp를 찾아간다 요청하는 값과 페이지 이름이 같아서 가능한
	@GetMapping("/read")
	public void read(@RequestParam int bNo, Model model) throws Exception {
		Board board = boardService.read(bNo);
		model.addAttribute(board);
	}
	
	@GetMapping("/delete")
	public String delete() {
		return null;
	}
}
