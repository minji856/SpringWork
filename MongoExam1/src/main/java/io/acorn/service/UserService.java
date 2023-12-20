package io.acorn.service;

import java.util.List;

import io.acorn.model.User;

public interface UserService {
	User createUser(User user);
	List<User> getAllUsers();
	User getUserById(String id);
	void deleteUserById(String id);
}
