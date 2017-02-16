package com.filproject.user.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.filproject.user.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService_dev;
	
	@RequestMapping(value = "login.do") //
	public String memLogin(HttpSession session) {
/*		if( session.getAttribute("sId") != null){
			
			return "redirect:/boardList_dev.do"; 
			
		}else {*/
		
		session.invalidate();
		return "member/memLogin"; 
	}
	
	@RequestMapping(value ="searchId_dev.do")
	public String memSearch(){
		return  "member/memSearch";
	}
	
	@RequestMapping(value = "memInfo_dev.do") //
	public String memInfo() {
		return "member/memInfo"; // 
	}
	
	@RequestMapping(value = "memSelect_dev.do")
	public String memSelect(Model model,@RequestParam Map<String, Object> paramMap) {
		model =  memberService_dev.memSelect(model, paramMap);
		return "board/boardList";
	}
	
	@RequestMapping(value = "memInsert_dev.do") //
	public String memInsert() {
		return "member/memInsert"; // 
	}
	
	
	@RequestMapping(value = "/memInsert_method.do")
	public @ResponseBody Map<String, Object> memInsert(@RequestParam Map<String, Object> paramMap) {
		return memberService_dev.memInsert(paramMap);
	}

	@RequestMapping(value = "memUpdate_dev.do")
	public String memUpdate(Model model,@RequestParam Map<String, Object> paramMap) {
		model =  memberService_dev.memSelect(model, paramMap);
		return "member/memUpdate";
	}

	@RequestMapping(value = "memUpdate_method.do")
	public String memUpdate(@RequestParam Map<String, Object> paramMap) {
		memberService_dev.memUpdate(paramMap);

		return "redirect:memInfo_dev.do";
	}
	
	@RequestMapping(value = "memDelete_dev.do")
	public String memDelete() {

		return "member/memDelete"; 
	}

	@RequestMapping(value = "memDelete_method.do")
	public String memDelete(@RequestParam Map<String, Object> paramMap) {
		memberService_dev.memDelete(paramMap);

		return "redirect:/logout_method.do";
	}
	
	@RequestMapping(value = "check_method.do")
	public @ResponseBody Map<String, Object> checkId(@RequestParam Map<String, Object> paramMap, HttpServletRequest request) {
		
		Map<String, Object> map = memberService_dev.checkId(paramMap);
		
		return map;
	}
	
	// 아이디 비밀번호 찾기
	@RequestMapping(value = "memSearch_method.do")
	public @ResponseBody Map<String, Object> memSearch(@RequestParam Map<String, Object> paramMap, HttpServletRequest request) {
		System.out.println("uri"+request.getRequestURI());
		
		Map<String, Object> map = memberService_dev.memSearch(paramMap);
		
		
		return map;
	}
	
	@RequestMapping(value = "/login_method.do")
	public @ResponseBody Map<String, Object> Login(@RequestParam Map<String, Object> paramMap, HttpSession session) {
		
		Map<String, Object> map = memberService_dev.login(paramMap, session);
		
		return map;
	}
	
	@RequestMapping(value = "/logout_method.do")
	public String Logout(HttpSession session) {
		session.invalidate();
		
		return "member/memLogin";
	}

}
