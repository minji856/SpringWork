package com.maymin.member.service;

import com.maymin.member.Member;
import com.maymin.member.MemberDao;

public class ChangePasswordService {
	private MemberDao memberDao;
		
	public ChangePasswordService() {}
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPass, String newPass) {
//		memberDao = new MemberDao(); 여기서 객체 생성하면 map이 다시 만들어지는거다
		
		// 해당 이메일이 존재하는지 여부 검사. 수가 적어서 변수로 처리
		// 조회하는
		Member member = memberDao.selectByEmail(email);
		System.out.println("changePassword: " + member);
		if(member == null) {
			System.out.println("해당 멤버가 없습니다.");
			return;
		}
		
		// 현재 비밀번호가 맞는지 확인하고 비밀번호 변경
		member.changePassword(oldPass, newPass);
		
		memberDao.update(member);
	}
}
