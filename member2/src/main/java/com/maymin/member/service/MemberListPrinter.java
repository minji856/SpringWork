package com.maymin.member.service;

import java.util.Collection;

import com.maymin.member.common.MemberPrinter;
import com.maymin.member.model.Member;
import com.maymin.member.repository.MemberDao;

public class MemberListPrinter {
	private MemberDao memDao; //db클래스랑 연결
	private MemberPrinter printer;
	
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	public void printAll() {
		Collection<Member> members = memDao.selectAll();
		
		for(Member m : members) {
			printer.print(m);
		}
		System.out.println();
	}
}
