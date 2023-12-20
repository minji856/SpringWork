package io.acorn.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.acorn.UsersService;
import io.acorn.model.Users;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UsersController {
	private final UsersService usersService;
	
	@PostMapping("/user")
	public String createUser(@RequestBody Users user) {
		return usersService.createUsers(user);
	}
	
	// http://localhost:9999/users?last=kim&first=one
	@GetMapping("/users")
	public List<Users> getUsers(
			@RequestParam(name="last") String last, 
			@RequestParam(name="first") String first){
		return usersService.getByName(last, first);
	}
	
	// http://localhost:9999/users/count?first=one
	@GetMapping("/users/count")
	public Integer getCount(@RequestParam(name="first") String first) {
		return usersService.getByNameLike(first);
	}
	
	@GetMapping("/users/date")
	public Boolean isLteDate(){
		return usersService.getDate(LocalDateTime.now());
	}
}
