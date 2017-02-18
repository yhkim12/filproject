package com.filproject.admin.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.filproject.admin.common.Constant;
import com.filproject.admin.member.service.AdminMemberService;
import com.filproject.code.CodeManager;

@Controller
@RequestMapping("/admin")
public class AdminMemberController {

	@Autowired
	private AdminMemberService adminMemberService;
	
	@Autowired
	private MessageSourceAccessor mr;
	
	//로그인 페이지로 이동
	@RequestMapping(value={"/", "/login"})
	public String login() {
		
		return Constant.adminDefaultPath + "login";
	}
	
	//로그인 ajax
	@RequestMapping(value={"/", "/loginAjax"})
	@ResponseBody
	public Map<String, Object> loginAjax(Map<String, Object> map) {
		
		return map;
	}
	
	@RequestMapping(value={"/test"})
	@ResponseBody
	public Map<String, Object> test(HttpServletRequest request) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("subCodeList", CodeManager.getSubCodeList(Constant.STAT_CD));
		resultMap.put("test", adminMemberService.test());
		
		return resultMap;
	}
}
