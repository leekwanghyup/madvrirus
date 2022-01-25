package chap03.spring.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import chap03.spring.assembler.Assembler;
import chap03.spring.dto.RegisterRequest;
import chap03.spring.exception.AlreadyExisitingMemberException;
import chap03.spring.exception.IdPasswordNotMatchingException;
import chap03.spring.exception.MemberNotFoundException;
import chap03.spring.service.ChangePasswordService;
import chap03.spring.service.MemberRegisterService;

public class MainForAssemble {
	
	private static Assembler assmbler = new Assembler(); 
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("명령어를 입력하세요");
			String command = reader.readLine();
			if(command.equals("exit")) {
				System.out.println("시스템을 종료합니다.");
				break; 
			}
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" ")); 
				continue;
			} else if (command.startsWith("change ")) {
				proccessChangeCommand(command.split(" "));
				continue; 
			}
			printHelp();
		}
		
	}

	private static void processNewCommand(String[] arg) {
		if(arg.length != 5) {
			printHelp();
			return; 
		}
		MemberRegisterService regSvc = assmbler.getRegSvc(); 
		RegisterRequest req = new RegisterRequest(); 
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호화 암호확인이 일치하지 않습니다.");
			return; 
		}
		try {
			regSvc.register(req);
			System.out.println("등록했습니다. \n");
		} catch (AlreadyExisitingMemberException e) {
			System.out.println("이미 존재하는 이메일 입니다.");
		}
		
	}
	
	private static void proccessChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return; 
		}
		String email = arg[1]; 
		String password = arg[2];
		String newPassword = arg[3];
		
		ChangePasswordService changPwdSvc = assmbler.getPwdSvc();
		try {
			changPwdSvc.changePassword(email, password, newPassword);
			System.out.println("비밀번호를 변경하였습니다.");
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.");
		} catch (IdPasswordNotMatchingException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.");
		}
	}
	
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요");
		System.out.println("명령어 사용법 : ");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비밀번호 변경비밀번호");
		System.out.println();
	}
	
}
