package com.maymin.member;

import com.maymin.member.service.ChangePasswordService;
import com.maymin.member.service.MemberRegisterService;

public class Assembler {
	private MemberDao memberDao;
	// 이걸 통해 객체를 생성하자
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	// 같이 저장되있으니까 이걸 써야한다
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService(memberDao);
	}
	
	public MemberDao getMemberDao() {
		return memberDao;
	}
	
	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}
	
	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
}
