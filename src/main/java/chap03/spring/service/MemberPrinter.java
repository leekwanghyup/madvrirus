package chap03.spring.service;

import org.springframework.stereotype.Component;

import chap03.spring.Member;
// chap03.spring.Member.MemberPrinter

@Component
public class MemberPrinter {

	public void print(Member member) {
		System.out.printf("회원정보 : 아이디=%d,  이메일=%s, 이름=%s, 등록일=%tF\n", 
				member.getId(), member.getEmail(), member.getName(), member.getRegisterDate());
	}

}
