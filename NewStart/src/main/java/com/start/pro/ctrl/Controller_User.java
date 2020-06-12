package com.start.pro.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.start.pro.dto.DTO_User;
import com.start.pro.models.user.IService_User;

@Controller
public class Controller_User {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IService_User service;
	
	
	@RequestMapping(value = "/userMain.do", method =  {RequestMethod.GET,RequestMethod.POST})
	public String userMain(Model model) {
		log.info("UserMain으로 이동합니다.!!@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		List<DTO_User> lists = service.searchAll();
		
		log.info("@@@@@@@@@@@@@@@@2외어ㅏㄶ왿@@@@@@@@@@@@@@@@@,{}",lists);
		model.addAttribute("lists",lists);
		return "board/user/userMain";
	}
	
	@RequestMapping(value = "/moveDetail.do", method = RequestMethod.GET)
	public String userDetail(HttpServletRequest req, Model model) {
		int user_seq = Integer.parseInt(req.getParameter("user_seq"));
		
		DTO_User dto = service.searchDetail(user_seq);
		model.addAttribute("dto",dto);
		return "board/user/userDetail";
	}
}






