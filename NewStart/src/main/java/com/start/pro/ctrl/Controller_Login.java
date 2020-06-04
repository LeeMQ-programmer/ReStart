package com.start.pro.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.start.pro.dto.DTO_User;
import com.start.pro.models.login.IService_Login;

@Controller
public class Controller_Login {

	@Autowired
	private IService_Login service;
	
	
	//로그인창 
	@RequestMapping(value = "/loginForm.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String loginForm(@RequestParam(value = "logout", required = false) String logout,
			Model model) {
		
//		model.addAttribute("dto",session.getAttribute("user"));
		
		if(logout != null) {
			System.out.println("로그아웃거칩니다");
			model.addAttribute("msg", "로그아웃 성공!");
		}
		
		return "login/LoginForm_cham";
	}

	//회원가입 완료시
	@RequestMapping(value = "/singUpSc.do", method = RequestMethod.POST)
	public String singUpSc(DTO_User dto) {
		System.out.println(dto.toString());
		service.signUp(dto);
		return "login/LoginForm_cham";
	}

	//로그인 완료시
	@RequestMapping(value = "/loginResult.do", method = RequestMethod.GET)
	public String loginResult(HttpSession session, Authentication auth, Model model) {
		System.out.println(session.getAttribute("user").toString());
		System.out.println(auth.toString());
		DTO_User dto = (DTO_User) session.getAttribute("user");
		model.addAttribute("dto",dto);
		
		return "login/LoginResult_cham";
	}

	//회원가입쪽으로
	@RequestMapping(value = "/singUpform.do", method = RequestMethod.GET)
	public String singUpForm() {
		System.out.println("dd");
		return "login/SignUp2_cham";
	}
	
	
	
}
