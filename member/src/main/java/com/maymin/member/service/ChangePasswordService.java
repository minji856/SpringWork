package com.maymin.member;

public class ChangePasswordService {
	private MemberDao memberDao;
		
	public ChangePasswordService() {}
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changePassword() {
		// 해당 이메일이 존재하는지 여부 검사
		memberDao.update(null);
	}
}
