package com.start.pro.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.start.pro.dto.DTO_Review;
import com.start.pro.models.review.IService_Review;

@Controller
public class Controller_Review {

	@Autowired
	private IService_Review service;
	
	@RequestMapping(value = "/reviewMain.do",method = RequestMethod.GET)
	public String searchAll(Model model) {
		List<DTO_Review> lists = service.searchAll();
		model.addAttribute("lists",lists);
		return "board/review/reviewMain";
	}
	
	
}





