package chap03.spring.assembler;

import chap03.spring.MemberDao;
import chap03.spring.service.ChangePasswordService;
import chap03.spring.service.MemberRegisterService;

public class Assembler {
	
	private MemberDao memberDao; 
	private MemberRegisterService regSvc; 
	private ChangePasswordService pwdSvc; 
	
	public Assembler() {
		memberDao = new MemberDao(); 
		regSvc = new MemberRegisterService(memberDao); 
		pwdSvc = new ChangePasswordService(memberDao);
	}


	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
}
