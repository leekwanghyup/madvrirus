package chap03.spring.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chap03.spring.Member;
import chap03.spring.MemberDao;

@Component
public class MemberListPrinter {
	
	private MemberDao memberDao; 
	private MemberPrinter printer;
	
	public MemberListPrinter() {
	}
	
	@Autowired
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		for(Member m : members) {
			printer.print(m);
		}
		
	}
	
	
}
