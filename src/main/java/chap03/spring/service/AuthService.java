package chap03.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chap03.spring.Member;
import chap03.spring.MemberDao;
import chap03.spring.dto.AuthInfo;
import chap03.spring.exception.WrongIdPasswordException;

@Service
public class AuthService {
	
	private MemberDao memberDao;

	@Autowired
	public AuthService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public AuthInfo authenticate(String email, String password) {
		Member member = memberDao.selectByEmail(email); 
		if(member==null) throw new WrongIdPasswordException(); 
		if(!member.matchPassword(password)) throw new WrongIdPasswordException();
		
		return new AuthInfo(member.getId(), member.getEmail(), member.getName());
	}
	
	
}
