package io.acorn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.acorn.model.User;
import io.acorn.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public User createUser(@RequestBody User user){
		return userService.createUser(user);
	}
	
	@GetMapping
	/** 
	 * 저장되있는걸 모두 꺼내는 
	 * */
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(name="id") String id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable(name="id") String id) {
		userService.deleteUserById(id);
	}
}
