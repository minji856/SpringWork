package com.maymin.member.common;

import org.springframework.stereotype.Component;

import com.maymin.member.model.Member;

// 딱히 역할을 구별하기 힘들 떄는 component
@Component
/* member정보를 모아서 이쁘게 뿌려줄거다 */
public class MemberPrinter {
	public void print(Member member) {
		System.out.printf("회원 정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
				member.getId(), member.getEmail(), member.getName(),
				member.getRegisterDate());
	}
}
