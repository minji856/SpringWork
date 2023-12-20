package io.acorn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.acorn.model.Users;

/**
 * 사용자 정보 저장
 * 메서드 이름은 규칙에 의해 만들어야함
 */
public interface UsersRepository extends JpaRepository<Users, Long>{
	List<Users> findFirst2ByUsernameLikeOrderByIDDesc(String name);
}
