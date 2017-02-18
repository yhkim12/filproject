package com.filproject.user.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.filproject.user.member.service.MemberService;

/**
 * 회원 관련 컨트롤러
 * @author dev-jjong
 *
 */
@Controller
@RequestMapping("/user/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
}
