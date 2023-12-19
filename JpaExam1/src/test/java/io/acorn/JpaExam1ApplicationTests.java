package io.acorn;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.acorn.model.Users;
import io.acorn.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class JpaExam1ApplicationTests {
	@Autowired
	UsersRepository usersRepository;

	@Test
	void contextLoads() {
	}
	
	@BeforeEach // Test 하기전에 반복 실행 하는
	void insertTestData() {
		Users user = new Users();
		user.setUsername("kim one");
		usersRepository.save(user);

		user = new Users();
		user.setUsername("lee one");
		usersRepository.save(user);
		
		user = new Users();
		user.setUsername("kim two");
		usersRepository.save(user);
		
		user = new Users();
		user.setUsername("lee one");
		usersRepository.save(user);
		
		user = new Users();
		user.setUsername("kim three");
		usersRepository.save(user);
	}
	
	@Test
	void findAllTest() {
		List<Users> userList = usersRepository.findAll();
		for(Users u : userList)
			log.info("[FindAll]: " + u.getID() + " | " + u.getUsername());
	}
	
	// Like 검색으로 2개만 값을 가져오는 쿼리
	// select * from users where username like 'kim%' ORDER BY id desc;
	@Test
	void find2ByNameTest() {
		List<Users> userList = usersRepository.findFirst2ByUsernameLikeOrderByIDDesc("kim%");
		for(Users u : userList)
			log.info("[Find2]: " + u.getID() + " | " + u.getUsername());
	}
}
