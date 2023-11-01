package io.acorn.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;

@Controller
@RequestMapping("/basic")
public class BasicController {
	@GetMapping("/text-basic")
	public String textBasic(Model model) {
		model.addAttribute("data", "Hello Spring");
		model.addAttribute("data2", "Hello <b>Spring</b>");
		/* html은 기본이여서 resolver 설정 안해줘도 된다 */
		return "basic/text-basic";
	}
	
	@GetMapping("/variable")
	public String variable(Model model) {
		User userA = new User("userA", 10);
		User userB = new User("userB", 10);
		
//		위 객체를 하나로 묶어준다
		List<User> list = new ArrayList(Arrays.asList(userA, userB));
		
//		앞으로 많이쓰게 된 형태
		Map<String, User> map = new HashMap<>();
		map.put("userA", userA);
		map.put("userB", userB);
		
		model.addAttribute("user", userA);
		model.addAttribute("users", list);
		model.addAttribute("userMap", map);
		
		return "basic/variable";
	}
	
	/* 중첩클래스 */
	@Getter // setter를 쓰려면 final로 바꿔줘야한다 그러면 값을 못 바꾸니까 생성자를 직접 만들어준것
	static class User{
		private String userName;
		private int age;
		
		public User(String userName, int age) {
			this.userName = userName;
			this.age = age;
		}
	}
}
