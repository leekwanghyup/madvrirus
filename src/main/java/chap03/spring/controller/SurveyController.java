package chap03.spring.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import chap03.spring.survey.AnsweredData;
import chap03.spring.survey.Question;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	@ModelAttribute("questions")
	private List<Question> createQuestions(){
		Question q1 = new Question("당신의 역할은 무엇입니까?",Arrays.asList("서버","프론트","백엔드","풀스택","기타"));
		Question q2 = new Question("많이 사용하는 개발도구는?",Arrays.asList("이클립스","인털리J","서브라임","Visual Studio","기타"));
		Question q3 = new Question("하고싶은 말을 적어라");
		return Arrays.asList(q1,q2,q3);
	}
	
	@GetMapping
	public String form(Model model) {
		return "survey/surveyForm";
	}
	
	@PostMapping
	public String submit(AnsweredData data) {
		return "survey/submitted";
	}
	
}
