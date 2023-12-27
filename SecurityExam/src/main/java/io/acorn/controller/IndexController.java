package io.acorn.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.acorn.auth.PrincipalDetails;
import io.acorn.model.Users;
import io.acorn.repository.UsersRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {
	private final UsersRepository usersRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder; // 관례상 소문자로 변수이름 지어줌
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String user(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		System.out.println("PrincipalDetails : " + principalDetails.getUser());
		return "user";
	}

	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/manager")
	@ResponseBody
	public String manager() {
		return "manager";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	@PostMapping("/join")
	public String join(Users user) {
		user.setRole("ROLE_USER");
		
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		// 변수에 저장한것을 다시 객체에 넣어준다
		user.setPassword(encPassword);
		
		usersRepository.save(user);
		
		// 자동으로 로그인 페이지로 이동
		return "redirect:/loginForm";
	}
	
	@GetMapping("/joinProc")
	@ResponseBody
	public String joinProc() {
		return "인증된 사람만 올 수 있는곳";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(){
		System.out.println("login");
		return "redirect:/";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/info")
	public @ResponseBody String info() {
		return "개인 정보";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
	@GetMapping("/data")
	public @ResponseBody String data() {
		return "데이터 정보";
	}
	
	@GetMapping("/test/login")
	@ResponseBody
	public String testLogin(Authentication auth,
				@AuthenticationPrincipal UserDetails userDetails) {
		System.out.println("/test/login =======================");
		// System.out.println("Authentication : " + auth.getPrincipal());
		PrincipalDetails principalDetails = (PrincipalDetails)auth.getPrincipal(); // 부모는 자식에게 참조 할수 없어서 다운 캐스팅
		// 권한만 꺼내 올수도 있고 정보들을 꺼내올 수 있다
		System.out.println("Authentication : " + principalDetails.getUser());
		System.out.println("userDetails : " + userDetails.getUsername());
		return "세션 정보 확인하기";
	}
	
	@GetMapping("/test/oauth/login")
	@ResponseBody
	public String testOAuthLogin(Authentication auth, 
			@AuthenticationPrincipal OAuth2User oauth) {
		System.out.println("/test/oauth/login ===============================");
		
		OAuth2User oauth2User = (OAuth2User)auth.getPrincipal();
		System.out.println("Authentication : " + oauth2User.getAttributes());
		System.out.println("oauth2User : " + oauth2User.getAttributes());
		
		return "OAuth 세션 정보 확인하기";
	}
}
