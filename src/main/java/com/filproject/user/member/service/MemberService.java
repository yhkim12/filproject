package com.filproject.user.member.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface MemberService {
	
	Model memSelect(Model model, Map<String, Object> paramMap);
	public Map<String, Object> memInsert(Map<String, Object>paramMap); 
	public Map<String, Object> memUpdate(Map<String, Object>paramMap);
	public Map<String, Object> memDelete(Map<String, Object>paramMap); 
	public Map<String, Object> checkId(Map<String, Object> paramMap); 
	public Map<String, Object> memSearch(Map<String, Object> paramMap); 
	public Map<String, Object> login(Map<String, Object> paramMap, HttpSession session); 
}
