package com.start.pro.ctrl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.start.pro.dto.DTO_Profile;
import com.start.pro.dto.DTO_User;
import com.start.pro.models.profile.IService_Profile;
import com.start.pro.models.user.IService_User;

@Controller
public class Controller_Header {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IService_User userService;
	@Autowired
	private IService_Profile proFileService;
	
	@RequestMapping(value = "/myPage.do", method = RequestMethod.GET)
	public String mypage(HttpSession session,Model model) {
		
		log.info("마이페이지 이동!");
		DTO_User newstart = (DTO_User) session.getAttribute("user");
		
		model.addAttribute("newstart",newstart);
		return "board/user/mypage";
	}
	
	
	@RequestMapping(value = "/proFile.do", method = RequestMethod.GET)
	public String searchProfile(HttpSession session,Model model) {
		DTO_User newstart = (DTO_User) session.getAttribute("user");
		DTO_Profile profileDto = proFileService.searchProfile(Integer.parseInt(newstart.getUser_seq()));
		
		model.addAttribute("newstart",newstart);
		model.addAttribute("profileDto", profileDto);
		
		return "board/user/profile";
	}
}











