package io.acorn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.acorn.model.Users;

// DB 연결해주는 CLASS ( JPA 방식 )
public interface UsersRepository extends JpaRepository<Users, Integer>{
	public Users findByUsername(String username);
}
