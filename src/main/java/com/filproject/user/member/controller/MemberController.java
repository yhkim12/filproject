package com.filproject.user.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	//회원 로그인 페이지로 이동
	@RequestMapping(value={"/", "/login"})
	public String login() {
		
		return "user/member/login";
	}
	
	//회원 로그인 ajax
	@RequestMapping(value={"/loginAjax"})
	@ResponseBody
	public Map<String, Object> loginAjax(@RequestParam Map<String, Object> map) throws Exception {

		return memberService.loginAjax(map);
	}
	
}
