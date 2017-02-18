package com.filproject.user.assesslist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.filproject.admin.common.Constant;

@Controller
@RequestMapping("/user/assesslist")
public class AssesslistController {
	
	//평가목록 리스트
	@RequestMapping(value="/list")
	public String list(Model model) {
		
		model.addAttribute("title", "평가목록");
		
		return Constant.userDefaultPath + "assesslist/list";
	}
	
	//평가목록 상세
	@RequestMapping(value="/view")
	public String view(Model model) {
		
		model.addAttribute("title", "평가목록상세");
		
		return Constant.userDefaultPath + "assesslist/view";
	}
	

}
