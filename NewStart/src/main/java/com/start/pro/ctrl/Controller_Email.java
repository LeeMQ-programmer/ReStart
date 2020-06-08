package com.start.pro.ctrl;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.start.pro.dto.DTO_Email;
import com.start.pro.email.AsyncTask_SendEmail;
import com.start.pro.models.email.IService_Email;
import com.start.pro.models.login.IService_Login;

@Controller
public class Controller_Email {

	@Autowired
	private IService_Email service;
	
	@Autowired
	private IService_Login loginservice;
	
	@Autowired
	private AsyncTask_SendEmail emailSend;
	
	//메일 보내기
	@RequestMapping(value = "/testmail.do", method = RequestMethod.GET)
	public String test() {
		
		DTO_Email dto = service.SelDetailAuto("0");
		System.out.println(dto.toString());
		return null;
	}
	
	
	//메일 보내기
	@RequestMapping(value = "/ljmail.do", method = RequestMethod.GET)
	public String LJ_Email(String code, String email, HttpServletResponse resp) {
		System.out.println("숑");
		
		DTO_Email dto = service.SelDetailAuto(code);
		
		String content = dto.getEmail_content();
		content = content.replace("#{email}", email);
		content =content.replace("#{key}", "1234");
		dto.setEmail_content(content);
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_email", dto.getUser_email());
		map.put("lj_key","1234");
		map.put("lj_code",code);
		service.sendLJ(map);
//		
		emailSend.sendOneMail(dto, resp);
		
		return "login/SignUp3";
	}
	
	
	//메일 인증
	@RequestMapping(value = "/ljmailchk.do", method = RequestMethod.GET)
	public String ljmailchk(String email, String key) {
		System.out.println(email);
		System.out.println(key);
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_email",email);
		map.put("lj_key", key);
		String code = service.LJKey(map);
		if(code != null) {
			System.out.println("인증되었습니다.");
			switch (code) {
			case "0": loginservice.changeNomal(email); return "login/SignUpResult";
			case "1": loginservice.changeSleep(email); return "login/SignUpResult";
			case "2":  return "login/SignUpResult";
			default : return "login/LJError";
			}
		}else {
			System.out.println("인증실패");
			return "login/LJError";
		}
	}
	
	
	
}
