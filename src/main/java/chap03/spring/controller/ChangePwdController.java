package chap03.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import chap03.spring.dto.AuthInfo;
import chap03.spring.dto.ChangePwdCommand;
import chap03.spring.dto.ChangePwdCommandValidator;
import chap03.spring.exception.MemberNotFoundException;
import chap03.spring.exception.WrongIdPasswordException;
import chap03.spring.service.ChangePasswordService;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {
	
	private ChangePasswordService changePasswordService;
	
	@Autowired
	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
	@GetMapping
	public String form(@ModelAttribute("command") ChangePwdCommand pwdCmd) {
		return "edit/changePwdForm";
	} 
	
	@PostMapping
	public String submit(@ModelAttribute("command") ChangePwdCommand pwdCmd, Errors errors,HttpSession session) {
		new ChangePwdCommandValidator().validate(pwdCmd, errors);
		if(errors.hasErrors()) return "edit/changePwdForm";
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		
		try {
			changePasswordService.changePassword(authInfo.getEmail(), pwdCmd.getCurrentPassword(), pwdCmd.getNewPassword());
			return "edit/changedPwd";
		} catch(WrongIdPasswordException e) {
			errors.rejectValue("currentPassword","notMatching");
			return "edit/changePwdForm";
		} catch(MemberNotFoundException e) {
			System.out.println("인증정보가 없습니다.");
			return "redirect:/";
		}
	}
	
}
