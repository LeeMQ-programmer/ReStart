package com.start.pro.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.start.pro.dto.DTO_User;
import com.start.pro.models.login.IService_Login;

@Controller
public class Controller_Login {

	@Autowired
	private IService_Login service;
	
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm() {
		return "login/LoginForm_cham";
	}

	
	@RequestMapping(value = "/singUpSc.do", method = RequestMethod.POST)
	public String singUpSc(DTO_User dto) {
		System.out.println(dto.toString());
		service.signUp(dto);
		return "login/LoginForm_cham";
	}

	@RequestMapping(value = "/singUpform.do", method = RequestMethod.GET)
	public String singUpForm() {
		System.out.println("dd");
		return "login/SignUp2_cham";
	}
	
	
	
}
