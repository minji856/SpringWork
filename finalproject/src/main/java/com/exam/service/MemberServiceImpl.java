package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.domain.Member;
import com.exam.domain.RegisterRequest;
import com.exam.repository.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;

	@Override
	public void registerMember(RegisterRequest dto) throws Exception {
		memberDao.registerMember(dto);
	}

	@Override
	public Member selectMember(String email) throws Exception {
		return null;
	}

	@Override /* boolean으로 받아도됨 */
	public Member selectWithPass(String email, String pw) throws Exception {
		Member member = memberDao.selectWithPass(email, pw);
		return member;
	}
}
