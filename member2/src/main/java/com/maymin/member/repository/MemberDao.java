package com.maymin.member.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.maymin.member.model.Member;

@Repository
public class MemberDao {
	//	DB 대신에 map 쓸 것이다
	private Map<String, Member> map = new HashMap<String, Member>();
	private static long nextId = 0;
	
	/* 한사람 조회기능 */
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	/* 모든 사람 조회기능 */
	// map 이여서 arraylist 못 쓴다
	public Collection<Member> selectAll(){
		return map.values(); // 전체데이터 가져오는 메서드
	}
	
	public void insert(Member member) {
		member.setId(++nextId); // Id도 증가시켜서 들어갈 거다
		// DB 대신에 저장하고 있는 작업
		map.put(member.getEmail(), member);
		System.out.println("test:" + map);
	}
	
	public void update(Member member) {
		// 이미 비밀번호가 바껴서 member에 들어가있는 상태다
		map.put(member.getEmail(), member);
		System.out.println("수정테스트 : " + member.getPassword());
	}
}
