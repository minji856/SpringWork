package io.acorn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.acorn.model.Users;
import io.acorn.service.UsersService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UsersController {
	private final UsersService usersService;
	
	@GetMapping("/users")
	public List<Users> getUsers(@RequestParam(name="name", required=false,
			defaultValue="") String name){
		return usersService.getUsersService(name);
	}
	
	@PostMapping("/users")
	public String createUser(@RequestBody Users user) {
		return usersService.createUserService(user);
	}
}
