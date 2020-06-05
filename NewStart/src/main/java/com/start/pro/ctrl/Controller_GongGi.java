package com.start.pro.ctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
	
	@RequestMapping(value = "/board/gonggi/gongGiList.do", method = RequestMethod.GET)
	public String gongGiList(Model model, DTO_Gonggi dto) {
		logger.info("gongGiList.do : \t {}", new Date());
		
		List<DTO_Gonggi> lists = service.GI_AllSelect(dto);
		model.addAttribute("lists", lists);
		
		return "board/gonggi/gonggi";
	}
	
}
