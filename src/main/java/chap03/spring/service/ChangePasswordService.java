package chap03.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chap03.spring.Member;
import chap03.spring.MemberDao;
import chap03.spring.exception.MemberNotFoundException;

@Component
public class ChangePasswordService {
	
	private MemberDao memberDao;
	
	public ChangePasswordService() {
	
	}
	
	@Autowired
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	} 
	
	// 조회 -> 조회수
	@Transactional
	public void changePassword(String email, String oldPw, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException(); 
		}
		member.changePassword(oldPw, newPwd);
		memberDao.update(member);
	}
	
	
}
