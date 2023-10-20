package com.maymin.member.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maymin.member.common.MemberPrinter;
import com.maymin.member.model.Member;
import com.maymin.member.repository.MemberDao;

@Service("listPrinter")
public class MemberListPrinter {
	private MemberDao memDao; //db클래스랑 연결
	private MemberPrinter printer;
	
	@Autowired
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}
	@Autowired
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
