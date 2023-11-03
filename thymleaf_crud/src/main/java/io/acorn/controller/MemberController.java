package io.acorn.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import io.acorn.domain.Member;
import io.acorn.repository.MemDao;

@Controller
public class MemberController {
	@Autowired
	private MemDao dao;
	
	@GetMapping("list")
	public String list(Model model) {
//		dao.getDataAll();
		ArrayList<Member> list = (ArrayList<Member>)dao.getDataAll();
		model.addAttribute("members", list);
		return "list";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insert(Member mem) {
		boolean result = dao.insertData(mem);
//		true값이면 값만 써줘도된다
		if(result) {
			return "redirect:/list";
		}
//		에러페이지 출력
		else {
			return "redirect:/error";
		}
	}
	
	@GetMapping("update")
	public String update(Member mem) {
		dao.updateData(mem);
		return "update";
	}
}

