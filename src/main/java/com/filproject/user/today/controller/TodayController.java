package com.filproject.user.today.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.filproject.admin.common.Constant;
import com.filproject.user.today.service.TodayService;

@Controller
@RequestMapping("/user/today")
public class TodayController {
	
	@Autowired
	private TodayService todayService;
		
	//오늘의 소개팅 리스트
	@RequestMapping(value="/list")
	public String todayList(Model model) throws Exception {
		
		System.out.println(" todayService.todayList() : "+todayService.todayList());
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("todayList", todayService.todayList());
		
		model.addAttribute("title", "오늘의 소개팅 목록");
		model.addAttribute("todayList", resultMap.get("todayList"));
		return Constant.userDefaultPath + "today/list";
	}

}
