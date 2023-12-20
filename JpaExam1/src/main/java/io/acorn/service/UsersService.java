package io.acorn.service;

import java.util.List;

import io.acorn.model.Users;

public interface UsersService {
	List<Users> getUsersService(String name);
	String createUserService (Users user);
}
