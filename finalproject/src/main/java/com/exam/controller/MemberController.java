package com.exam.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.exam.domain.Member;
import com.exam.domain.RegisterRequest;
import com.exam.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/add")
	public String step1() {
		return "member/step1";
	}

	/* 요청하려는 이름이랑 페이지 이름이 같아서 경로 생략 */
	@PostMapping("/step2")
	public String step2(@RequestParam(value="agree", defaultValue="false") boolean agree) {
		if(!agree) {
			return "/member/step1";
		}
		
		return "/member/step2";
	}
	
	@PostMapping("/step3")
	public String step3(@ModelAttribute RegisterRequest dto) throws Exception {
		memberService.registerMember(dto); /* 이름 비번 이메일이 저장되어서 옴 */
		return "/member/step3";
	}
	
	@GetMapping("/login")
	public void login() {
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, HttpServletRequest req) {
		String msg = null;
		try {
			msg = URLEncoder.encode("id 또는 password가 일치하지 않습니다.", "utf-8");
			Member member = memberService.selectWithPass(id, pwd);
			
			/* session을 만드는게 아니고 가져오는거다 없으면 받아오면 됨
			 * 세션 아이디에 이사람 이메일이 있으면 로그인 한거다*/
			 ////HttpSession session = req.getSession();
			 ////session.setAttribute("id", member.getName());
			WebUtils.setSessionAttribute(req, "id", member.getName());
		}
		/* null 값인 경우 catch 로 빠짐 	*/
		catch(Exception err) {
			return "redirect:/member/login?msg=" + msg;
		}
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/"; /* 이게 있어야 자동적으로 새로고침 */
	}
}
