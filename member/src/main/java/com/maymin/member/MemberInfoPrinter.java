package com.maymin.member;

import com.maymin.member.service.MemberPrinter;

/* 일종의 출력 service 역할
 * DB로 부터 가져온걸 사용자에게 잘 보여주는 클래스 */
public class MemberInfoPrinter {
	private MemberDao memDao; //db클래스랑 연결
	private MemberPrinter printer;
	
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		
		if(member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		
		printer.print(member);
		System.out.println();
	}
	
}
