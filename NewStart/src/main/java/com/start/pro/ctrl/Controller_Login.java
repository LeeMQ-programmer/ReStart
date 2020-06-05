package com.start.pro.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
			@RequestParam(value = "error", required = false) String error,
			Model model, HttpServletRequest req) {

		//		model.addAttribute("dto",session.getAttribute("user"));

		if(logout != null) {
			System.out.println("로그아웃거칩니다");
			model.addAttribute("msg", "로그아웃 성공!");
		}

		if (error != null) {
			model.addAttribute("error", req.getAttribute("error"));
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
//		System.out.println(session.getAttribute("user").toString());
		System.out.println(auth.toString());
//		DTO_User dto = (DTO_User) session.getAttribute("user");
		model.addAttribute("dto",auth.toString());

		return "login/LoginResult_cham";
	}

	//회원가입쪽으로
	@RequestMapping(value = "/singUpform.do", method = RequestMethod.GET)
	public String singUpForm() {
		System.out.println("dd");
		return "login/SignUp2_cham";
	}

	//아이디찾자
	@RequestMapping(value = "/goFId.do", method = RequestMethod.GET)
	public String goFId() {
		return "login/FindId1";
	}
	
	///FindId.do
	@RequestMapping(value = "/FindId.do", method = RequestMethod.GET)
	public String FindId(Model model,String phone) {
		System.out.println("phone");
		String id = service.findId(phone);
		model.addAttribute("id", id);
		return "login/FindId2";
	}

	
	//비밀번호 찾자
	@RequestMapping(value = "/goFPW.do", method = RequestMethod.GET)
	public String goFPW() {
		return "login/FindPW1";
	}

	
	@RequestMapping(value = "/ChangePW.do", method = RequestMethod.POST)
	public String ChangePW(String email, String newPW, Model model) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_email", email);
		map.put("user_pw", newPW);

		service.updatePW(map);
		
		return "login/FindPW2";
	}
	
	
	// 중복검사
	@RequestMapping(value = "/idChk.do", method = RequestMethod.GET)
	public String idChk() {
		return "login/MultiChkId";
	}
	
	//./MultiChkId.do
	@RequestMapping(value = "/MultiChkId.do", method = RequestMethod.GET)
	public String MultiChkId(String id, Model model) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_email", id);
		boolean isc = service.MultipleChk(map);
		model.addAttribute("result", isc);
		return "login/MultiChkId2";
	}
	
	

	
	@RequestMapping(value = "/MultiChkNick.do", method = RequestMethod.GET)
	public String MultiChkNick(String name, Model model) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_nickname", name);
		boolean isc = service.MultipleChk(map);
		model.addAttribute("result", isc);
		return "login/MultiChkId2";
	}


	
	// 휴면회원을 일반회원으로 등급변경(이메일 인증시)
	@RequestMapping(value = "/changeN.do", method = RequestMethod.GET)
	public String changeN(String seq) {
		service.changeNomal(seq);
		return "login/LoginForm_cham";
	}
	
	// 휴면이나 잠금계정 보내기 EmailChk.do
	@RequestMapping(value = "/EmailChk.do", method = RequestMethod.GET)
	public String EmailChk() {
		return "login/EmailChk";
	}
	
}
