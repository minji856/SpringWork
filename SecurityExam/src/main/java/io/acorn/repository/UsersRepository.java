package io.acorn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.acorn.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	
}
