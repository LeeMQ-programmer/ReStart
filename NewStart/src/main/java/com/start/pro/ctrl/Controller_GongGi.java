package com.start.pro.ctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
	
	/**
	 * 공지사항 전체 조회
	 * @param model, dto
	 * @return lists
	 */
	@RequestMapping(value = "/gongGiList.do", method = RequestMethod.GET)
	public String gongGiList(Model model) {
		logger.info("gongGiList.do : \t {}", new Date());
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		List<DTO_Gonggi> lists = service.GI_AllSelect(null);
		
		model.addAttribute("lists", lists);
		
		
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒"+lists.toString()+"▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		
		return "board/gonggi/gonggi";
	}
	
	@RequestMapping(value = "/gonggiOneSel.do", method = RequestMethod.GET)
	public String gongGiOneSel(Model model, String seq, String category) {
		logger.info("gongGiOneSel.do : \t {}", new Date());
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gi_seq", seq);
		map.put("gi_category", category);
		
		DTO_Gonggi dto = service.GI_OneSelect(map);
		
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒"+dto+"▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		
		model.addAttribute("dto", dto);
		
		return "board/gonggi/gonggiOneSel";
	}
	
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modify(Model model, String seq, String title, String category, String content, String regdate) {
		logger.info("modify.do : \t {}", new Date());
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		
		System.out.println("▒▒▒▒▒▒▒"+title+"▒▒▒▒▒");
		DTO_Gonggi dto = new DTO_Gonggi(seq, 1000, category, title, content, regdate);
		
		model.addAttribute("dto", dto);
		
		return "board/gonggi/modify";
	}
	
	@RequestMapping(value = "/modifyForm.do", method = RequestMethod.POST)
	public String modifyForm(String seq, String title, String content, String category) {
		logger.info("modifyForm.do : \t {}", new Date());
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		
		DTO_Gonggi dto = new DTO_Gonggi(seq, title, content, category);
		System.out.println(category);
		boolean n;
		n = service.GI_Update(dto);
		
		return "redirect:/gongGiList.do";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String deleteGi(String seq) {
		logger.info("delete.do : \t {}", new Date());
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println(seq);
		
		boolean n;
		n = service.GI_Delete(seq);
		
		return "redirect:/gongGiList.do";
	}
	
	@RequestMapping(value = "/writeFrom.do", method = RequestMethod.POST)
	public String writeForm() {
		
		
		return null;
	}
	
	
}
