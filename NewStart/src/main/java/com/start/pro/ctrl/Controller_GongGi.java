package com.start.pro.ctrl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.start.pro.models.gonggi.IService_Gonggi;

@Controller
public class Controller_GongGi {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IService_Gonggi service;
	
	@RequestMapping(value = "/gongGiList.do", method = RequestMethod.GET)
	public String gongGiList() {
		logger.info("gongGiList.do : \t {}", new Date());
		
//		user
		
		
		return "gonggi";
	}
	
}
