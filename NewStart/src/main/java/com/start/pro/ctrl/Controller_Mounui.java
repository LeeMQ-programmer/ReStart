package com.start.pro.ctrl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.start.pro.dto.DTO_FAQ;
import com.start.pro.dto.DTO_Mounui;
import com.start.pro.dto.DTO_User;
import com.start.pro.models.mounui.IService_Mounui;

@Controller
public class Controller_Mounui {

	@Autowired
	private IService_Mounui service;

	@RequestMapping(value = "/mounuiboard.do", method = RequestMethod.GET)
	public String mounuiboard(Model model){

		List<DTO_FAQ> Fdto = service.getCategory();
		model.addAttribute("Fdto",Fdto);
		
		return "board/mounui/InsertBoard";
	}
	
	//insertBoard
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(DTO_Mounui dto, HttpSession session,Model model){
		
		DTO_User user = (DTO_User) session.getAttribute("newstart");
		dto.setUser_seq(user.getUser_seq());
		System.out.println(dto.toString());
//		System.out.println(user.toString());
		service.insertBoard(dto);
		
		return "board/mounui/InsertSuccess";
	}

	//유저 문이 게시판
	@RequestMapping(value = "/UserMBoard.do", method = RequestMethod.GET)
	public String UserMBoard(Model model, HttpSession session){
		
		String userSeq = ((DTO_User) session.getAttribute("newstart")).getUser_seq();
		List<DTO_Mounui> dtos = service.userBoard(userSeq);
		
		model.addAttribute("dtos", dtos);
		return "board/mounui/UserMBoard";
	}

	// 유저 문의 상세보기
	@RequestMapping(value = "/UserMBoardDetail.do", method = RequestMethod.GET)
	public String UserMBoardDetail(String seq, Model model){
		
		DTO_Mounui dto = service.userBoardDetail(seq);
		
		System.out.println("왜안돼"+dto.toString());
		
		model.addAttribute("dto", dto);
		return "board/mounui/UserMBoardD";
	}

	
	@RequestMapping(value = "/UserMBoardDel.do", method = RequestMethod.GET)
	public String UserMBoardDel(String[] seq) {
//		Map<String, String>
//		service.delBoard(map);
		
		System.out.println(seq[0]);
		
		return "redirect:/UserMBoard.do";
	}
	
}
