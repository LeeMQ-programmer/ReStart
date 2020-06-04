package com.start.pro.ctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.start.pro.dto.DTO_Gonggi;
import com.start.pro.models.gonggi.IService_Gonggi;

@Controller
public class Controller_GongGi {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IService_Gonggi service;
	
	@RequestMapping(value = "/gongGiList.do", method = RequestMethod.GET)
	public String gongGiList(Model model) {
		logger.info("gongGiList.do : \t {}", new Date());
		
		DTO_Gonggi dto = (DTO_Gonggi) service.GI_AllSelect();
		model.addAttribute("dto", dto);
		
		return "gonggi";
	}
	
}
