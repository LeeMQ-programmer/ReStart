package com.start.pro.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.start.pro.dto.DTO_Email;

@Controller
public class Controller_Email {

	
	@RequestMapping(value = "/ljmail.do", method = RequestMethod.GET)
	public String LJ_Email(String code) {
		
		
		
		return null;
	}
	
}
