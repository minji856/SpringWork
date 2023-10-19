package com.maymin.member;

import java.util.Date;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService() {} // 기본 생성자 생성
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void regist(RegisterRequest req) {
		// 같은 이메일이 있는지 여부 검사
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			System.out.println("같은 이메일이 있습니다.");
			return;
		}
//		멤버 객체로 포장
		Member newMem = new Member(req.getEmail(), req.getPassword(), req.getName(), 
				new Date());
		
		memberDao.insert(newMem);
	}
}
