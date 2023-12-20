package io.acorn.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.acorn.model.Users;

/**
 * 쿼리 메서드 직접 만드는 클래스
 * 원랜 @Repository 붙여주는게 좀 더 안전할 수 있지만 JpaRepository를 상속받으면서 생략해줘도 되긴함
 * 무조건 다 find로 시작하는게 아니니까 APi 찾아보기
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	// 성과 이름으로 조회를 한다. 단 userId로 내림차순 정렬하고 결과는 5개만 가져온다.
	List<Users> findFirst5ByLastnameAndFirstnameOrderByUserIdDesc(String lastName, String fristName);
	// 위의 메서드가 SELECT * FROM users WHERE lastname="" and firstname="" limit5; 인격
	
	// 대소문자 무시하고 Like쿼리를 이용하여 해당하는 데이터 갯수를 가져온다.
	Integer countByFirstnameIgnoreCaseLike(String first);
	
	// 입력받은 날짜보다 startDate가 적거나 같은 데이터가 있다면 true를, 없다면 false를 리턴
	Boolean existsByStartDateLessThanEqual(LocalDateTime startDate);
}
