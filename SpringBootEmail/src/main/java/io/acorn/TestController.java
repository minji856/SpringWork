package io.acorn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {
	// 값을 제대로 받는지 확인하기 위해 final 추가
	private final MailService mailService;
	
	@GetMapping("/mail/send")	 
	public String getSendMail() {
		return "index.html";
	}
	
	@PostMapping("/mail/send")
	public void sendMail(MailDto mail) {
		mailService.sendMail(mail);
	}
	
	@ResponseBody
	@GetMapping("/login")
	public LoginDto getLogin() {
		return new LoginDto("hong", "1234");
	}
}

@Data
@AllArgsConstructor
class LoginDto{
	private String userid;
	private String userpw;
}