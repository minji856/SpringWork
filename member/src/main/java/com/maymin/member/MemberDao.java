package com.maymin.member;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
//	DB 대신에 map 쓸 것이다
	private Map<String, Member> map = new HashMap<String, Member>();
	private static long nextId = 0;
	
	/* 한사람 조회기능 */
	public Member selectByEmail(String email) {
		return null;
	}
	/* 모든 사람 조회기능 */
//	map 이여서 arraylist 못 쓴다
	public Collection<Member> selectAll(){
		return null;
	}
	
	public void insert(Member member) {
		member.setId(++nextId); // Id도 증가시켜서 들어갈 거다
//		DB 대신에 저장하고 있는 작업
		map.put(member.getEmail(), member);
	}
	
	public void update(Member member) {
		
	}
}
