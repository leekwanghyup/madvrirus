package chap03.spring.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chap03.spring.Member;
import chap03.spring.MemberDao;
import chap03.spring.dto.RegisterRequest;
import chap03.spring.exception.AlreadyExisitingMemberException;

@Service
public class MemberRegisterService {
	
	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void register(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null ) {
			throw new AlreadyExisitingMemberException("dup email : " + req.getEmail());
		}
		
		// Member 객체 생성 후 dao로부터 insert()메서드 호출
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}
}
