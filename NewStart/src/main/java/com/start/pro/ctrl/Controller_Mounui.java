package com.start.pro.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.start.pro.dto.DTO_FAQ;
import com.start.pro.models.mounui.IService_Mounui;

@Controller
public class Controller_Mounui {

	@Autowired
	private IService_Mounui service;

	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(Model model){

		List<DTO_FAQ> Fdto = service.getCategory();
		model.addAttribute("Fdto",Fdto);
		
		return "board/mounui/InsertBoard";
	}
}
