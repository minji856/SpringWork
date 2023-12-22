package com.self.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.self.dto.MemberDto;

/**
 * API 기본 작성 
 */

@RestController
@RequestMapping("/api/v1/get-api") // 내부에 선언한 메서드의 URL 리소스 앞에 mapping의 값이 공통으로 추가
public class GetController {
	
	// http://localhost:9999/api/v1/get-api/name
	@GetMapping("/name") // 매개변수가 없는 GET 메서드
	@ResponseBody
	public String getName() {
		return "이름을 출력함";
	}
	
	// http://localhost:9999/api/v1/get-api/variable1/String 값 ; 500 에러
	@GetMapping(value = "/variable1/{variable}")
	public String getVariable1(@PathVariable String variable) {
		return variable;
	}
	
	@GetMapping(value = "/variable2/{variable}") // PathVariable(변수명 지정)
	public String getVariable2(@PathVariable("variable") String var) {
		return var;
	}
	
	// http://localhost:9999/api/v1/get-api/request1?name=value1&email=value2&organization=value3
	@GetMapping(value = "/request1")
	public String getRequestParam1(
		@RequestParam String name,
		@RequestParam String email,
		@RequestParam String organization) {
			return name + " " + email + " " + organization;
	}
	
	// 쿼리스트링에 어떤 값이 들어올지 모를 때 Map 활용
	// http://localhost:9999/api/v1/get-api/request2?key1=value1&key2=value2
	@GetMapping("/request2")
	public String gerRequestParam2(@RequestParam Map<String, String> param) {
		StringBuilder sb = new StringBuilder();
		
		param.entrySet().forEach(entry -> {
			sb.append(entry.getKey() + " : " + entry.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	// http://localhost:9999/api/v1/get-api/request3?name=value1&email=value2&organization=value3
	public String getRequestParam3(MemberDto memberDto) {
		// return memberDto.getName() + " " + memberDto.getEamil() + " " + memberDto.getOrganization();
		return memberDto.toString();
	}
}
