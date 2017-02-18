package com.filproject.admin.member.service;

import java.util.Map;

public interface AdminMemberService {

	Map<String, Object> test() throws Exception;

	//login ajax
	Map<String, Object> loginAjax(Map<String, Object> map) throws Exception;

}
