package com.filproject.admin.code.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.filproject.admin.code.service.AdminCodeService;
import com.filproject.admin.common.Constant;

@Controller
@RequestMapping("/admin/code")
public class AdminCodeController {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AdminCodeService adminCodeService;
	
	@Autowired
	private MessageSourceAccessor mr;
	
	//코드 목록
	@RequestMapping(value={"/list"})
	public String codeList(@RequestParam Map<String, Object> map, Model model) {
		
		try{
			model.addAllAttributes(adminCodeService.codeList(map)); 
		} catch (Exception e) {
			logger.error("", e);
		}
		
		return Constant.adminDefaultPath + "code/list";
	}
	
}
