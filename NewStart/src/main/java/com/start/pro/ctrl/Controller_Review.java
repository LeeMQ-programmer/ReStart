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
import org.springframework.web.bind.annotation.ResponseBody;

import com.start.pro.dto.DTO_Review;
import com.start.pro.dto.DTO_User;
import com.start.pro.models.review.IService_Review;

@Controller
public class Controller_Review {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IService_Review service;
	//후기 전체 페이지 조회
	@RequestMapping(value = "/reviewMain.do",method = {RequestMethod.GET,RequestMethod.POST})
	public String searchAll(Model model,HttpSession session) {
		log.info("@@@@@@@@@후기 전체 페이지@@@@@@@@@@@@@@@@2");

		List<DTO_Review> lists = service.searchAll();
		DTO_User newstart = (DTO_User) session.getAttribute("user");

		model.addAttribute("lists",lists);
		model.addAttribute("newstart",newstart);

		return "board/review/reviewMain";
	}
	
	//후기 상세 페이지 조회
	@RequestMapping(value = "/reviewDetail.do",method = RequestMethod.GET)
	public String searchDetail(Model model,HttpServletRequest req,HttpSession session) {
		log.info("@@@@@@@@@후기 상세 페이지@@@@@@@@@@@@@@@@2");
		int re_seq = Integer.parseInt(req.getParameter("re_seq"));
		DTO_User newstart = (DTO_User) session.getAttribute("user");
		DTO_Review dto = service.searchDetail(re_seq);
		model.addAttribute("dto",dto);
		model.addAttribute("newstart",newstart);

		return "board/review/reviewDetail"; 
	}
	
	//후기 게시글 작성 페이지 이동
	@RequestMapping(value = "/writeReview.do", method = RequestMethod.GET)
	public String writeReview(HttpSession session,Model model) {
		log.info("@@@@@@@@@@@@@@@@후기 작성 페이지 이동@@@@@@@@@@@@@");
		DTO_User newstart  = (DTO_User) session.getAttribute("user");

		model.addAttribute("newstart",newstart);
		return "board/review/writeReview";
	}
	
	//후기 게시글 작성
	@RequestMapping(value = "/insertReview.do", method = RequestMethod.POST)
	public String insertReview(HttpServletRequest req) {
		log.info("@@@@@@@@@@@@@@@@후기 작성 @@@@@@@@@@@@@,{}",new Date());
		int user_seq =	Integer.parseInt(req.getParameter("user_seq"));
		String re_title = req.getParameter("re_title");
		String re_content = req.getParameter("re_content");
		int re_teacher = Integer.parseInt(req.getParameter("re_teacher"));
		int re_star = Integer.parseInt(req.getParameter("re_star"));
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@제목"+re_title);
		DTO_Review dto = new DTO_Review(user_seq, re_title,  re_content, re_teacher, re_star);
		
		
		service.insertReview(dto);
		System.out.println("완료");
		return "redirect:/reviewMain.do";
	}
	
	//후기 수정 페이지 이동
	@RequestMapping(value = "/moveModify.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String moveModify(HttpSession session,Model model,HttpServletRequest req) {
		log.info("@@@@@@@@@@@@@@@@후기 수정 페이지 이동@@@@@@@@@@@@@");
		int re_seq = Integer.parseInt(req.getParameter("re_seq"));
		DTO_Review dto = service.searchDetail(re_seq);

		model.addAttribute("dto",dto);
		
		return "board/review/reviewModify";
	}

	//후기 수정
	@RequestMapping(value = "/modifyReview.do",method = RequestMethod.GET)
	public String modifyReview(HttpServletRequest req) {
		log.info("@@@@@@@@@@@@@@@@후기 작성 @@@@@@@@@@@@@,{}",new Date());
		int re_seq =	Integer.parseInt(req.getParameter("re_seq"));
		String re_title = req.getParameter("re_title");
		String re_content = req.getParameter("re_content");
		int re_star = Integer.parseInt(req.getParameter("re_star"));
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@제목 : "+re_title);
		DTO_Review dto = new DTO_Review(re_seq, re_title,  re_content, re_star);
		
		service.updateReview(dto);
		return "redirect:/reviewMain.do";
	}
	
	//답글 작성페이지 이동
	@RequestMapping(value = "/moveReply.do", method = RequestMethod.POST)
	public String writeReply(Model model,HttpSession session,HttpServletRequest req) {
		int re_seq = Integer.parseInt(req.getParameter("re_seq"));
		DTO_User newstart = (DTO_User) session.getAttribute("user");
		DTO_Review uDto = service.searchDetail(re_seq);
		
		model.addAttribute("uDto",uDto);
		model.addAttribute("newstart",newstart);
		return "board/review/writeReply";
	}
	
	//답글 작성
	@RequestMapping(value = "/insertReply.do", method = RequestMethod.GET)
	public String insertReply(HttpServletRequest req) {
		
		int re_seq = Integer.parseInt(req.getParameter("re_seq"));
		String re_title = req.getParameter("re_title");
		String re_content = req.getParameter("re_content");
		int re_star = Integer.parseInt(req.getParameter("re_star"));
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@제목"+re_title);
		DTO_Review dto = new DTO_Review(re_seq, re_title,  re_content, re_star);
		
		service.replyInsert(re_seq, dto);
		
		return "redirect:/reviewMain.do";
	}
	
	// 게시글 삭제
	@RequestMapping(value = "/reviewDelete.do", method = RequestMethod.GET)
	public String reviewDelete(HttpServletRequest req) {
		int re_seq = Integer.parseInt(req.getParameter("re_seq"));
		log.info(re_seq+"@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		service.delReview(re_seq);
		return "redirect:/reviewMain.do";
	}
	
	
}





