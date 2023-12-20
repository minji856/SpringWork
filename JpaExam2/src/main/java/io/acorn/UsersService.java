package io.acorn;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import io.acorn.model.Users;
import io.acorn.repository.UsersRepository;
import lombok.RequiredArgsConstructor;

/**
 * Service는 이름 내맘대로 만들어도됨
 */
@Service
@RequiredArgsConstructor
public class UsersService {
	private final UsersRepository usersRepository;
	
	// 규칙에 의해만든 쿼리메서드 호출
	public List<Users> getByName(String last, String frist){
		return usersRepository.findFirst5ByLastnameAndFirstnameOrderByUserIdDesc(last, frist);
	}
	
	// 대소문자 무시하고 Like쿼리를 이용하여 해당하는 데이터 갯수를 가져온다.
	public int getByNameLike(String frist){
		return usersRepository.countByFirstnameIgnoreCaseLike(frist);
	}
	
	// 입력받은 날짜보다 startDate가 적거나 같은 데이터가 있다면 true를, 없다면 false를 리턴
	public boolean getDate(LocalDateTime date) {
		return usersRepository.existsByStartDateLessThanEqual(date);
	}
	
	public String createUsers(Users user) {
		usersRepository.save(user);
		return "등록 완료";
	}
}
