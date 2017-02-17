package com.filproject.admin.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.filproject.admin.common.Constant;
import com.filproject.admin.member.service.AdminMemberService;

@Controller
@RequestMapping("/admin")
public class AdminMemberController {

	@Autowired
	private AdminMemberService adminMemberService;
	
	@Autowired
	private MessageSourceAccessor mr;
	
	
	@RequestMapping(value={"/", "/login"})
	public String login() {
		
		return Constant.adminDefaultPath + "login";
	}
	
	@RequestMapping(value={"/test"})
	@ResponseBody
	public Map<String, Object> test(HttpServletRequest request) throws Exception {
		
		
		System.out.println("msg test : "+request.getAttribute("msg"));
		
		return adminMemberService.test();
	}
}
