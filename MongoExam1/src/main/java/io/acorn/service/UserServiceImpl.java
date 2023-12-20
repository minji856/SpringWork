package io.acorn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.acorn.model.User;
import io.acorn.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteUserById(String id) {
		userRepository.deleteById(id);
	}

}
