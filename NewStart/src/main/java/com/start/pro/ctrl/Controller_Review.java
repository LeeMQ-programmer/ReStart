package com.start.pro.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.start.pro.dto.DTO_Review;
import com.start.pro.dto.DTO_User;
import com.start.pro.models.review.IService_Review;

@Controller
public class Controller_Review {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IService_Review service;
	
	@RequestMapping(value = "/reviewMain.do",method = RequestMethod.GET)
	public String searchAll(Model model) {
		List<DTO_Review> lists = service.searchAll();
		model.addAttribute("lists",lists);
		return "board/review/reviewMain";
	}
	
	@RequestMapping(value = "/reviewDetail.do",method = RequestMethod.GET)
	public String searchDetail(Model model,HttpServletRequest req) {
		int re_seq = Integer.parseInt(req.getParameter("re_seq"));
		DTO_Review dto = service.searchDetail(re_seq);
		System.out.println("@@@@@@@@@"+dto+"@@@@@@@@@@@@@@@@2");
		model.addAttribute("dto",dto);

		return "board/review/reviewDetail"; 
	}
	
	@RequestMapping(value = "/writeReview.do", method = RequestMethod.GET)
	public String writeReview(HttpSession session,Model model) {
		log.info("@@@@@@@@@@@@@@@@후기 작성 페이지 이동@@@@@@@@@@@@@");
		DTO_User dto  = (DTO_User) session.getAttribute("newstart");
		model.addAttribute("dto",dto);
		return "board/review/writeReview";
	}
	
	@RequestMapping(value = "/insertReview.do", method = RequestMethod.GET)
	public String insertReview(HttpServletRequest req) {
		log.info("@@@@@@@@@@@@@@@@후기 작성 @@@@@@@@@@@@@,{}",new Date());
		int user_seq = 4;
		String re_title = req.getParameter("re_title");
		String re_content = req.getParameter("re_content");
		int re_teacher = Integer.parseInt(req.getParameter("re_teacher"));
		int re_star = Integer.parseInt(req.getParameter("re_star"));
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@제목"+re_title);
		DTO_Review dto = new DTO_Review(user_seq, re_title, re_content, re_teacher, re_star);
		
		
		service.insertReview(dto);
		System.out.println("완료");
		return "board/review/reviewMain";
	}
//	
	
}





