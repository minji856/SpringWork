package io.acorn;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import io.acorn.model.Users;

/**
 * Service는 이름 내맘대로 만들어도됨
 */
@Service
public class UsersService {
	// 성과 이름으로 조회를 한다. 단 userId로 내림차순 정렬하고 결과는 5개만 가져온다.
	List<Users> getByName(String last, String frist){
		return null;
	}
	
	// 대소문자 무시하고 Like쿼리를 이용하여 해당하는 데이터 갯수를 가져온다.
	int getByNameLike(){
		return 0;
	}
	
	// 입력받은 날짜보다 startDate가 적거나 같은 데이터가 있다면 true를, 없다면 false를 리턴
	boolean getDate(LocalDateTime date) {
		return true;
	}
	
	public void createUsers(Users user) {
		
	}
}
