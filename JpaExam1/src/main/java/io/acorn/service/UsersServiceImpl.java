package io.acorn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.acorn.model.Users;
import io.acorn.repository.UsersRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
	private final UsersRepository usersRepository;
	
	@Override
	public List<Users> getUsersService(String name) {
		if(name.isBlank()) {
			return usersRepository.findAll();
		}
		else {
			return usersRepository.findFirst2ByUsernameLikeOrderByIDDesc(name + "%");
		}
	}

	@Override
	public String createUserService(Users user) {
		usersRepository.save(user);
		return "등록 완료";
	}
}
