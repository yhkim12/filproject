package com.filproject.admin.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.filproject.admin.common.Constant;
import com.filproject.admin.member.service.AdminMemberService;
import com.filproject.code.CodeManager;

@Controller
@RequestMapping("/admin/board")
public class AdminBoardController {

	@Autowired
	private AdminMemberService adminMemberService;
	
	@Autowired
	private MessageSourceAccessor mr;
	
	//회원 목록 조회
	@RequestMapping(value={"/list"})
	public String boardList(@RequestParam Map<String, Object> map) throws Exception {

		return Constant.adminDefaultPath + "/board/list";
	}
	
}
