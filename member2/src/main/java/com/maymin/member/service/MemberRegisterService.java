package com.maymin.member.service;

import java.util.Date;

import com.maymin.member.model.Member;
import com.maymin.member.model.RegisterRequest;
import com.maymin.member.repository.MemberDao;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService() {} // 기본 생성자 생성
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void regist(RegisterRequest req) {
		// 같은 이메일이 있는지 여부 검사
		// memberDao = new MemberDao(); // 이게 있어야 전달을 한다 assembler에 넣음
		
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			System.out.println("같은 이메일이 있습니다.");
			return;
		}
		// 멤버 객체로 포장. 순서 주의
		Member newMem = new Member(req.getEmail(), req.getName(),
				req.getPassword(), new Date());
		
		memberDao.insert(newMem);
	}
}
