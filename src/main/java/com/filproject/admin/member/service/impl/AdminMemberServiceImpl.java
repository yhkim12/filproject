package com.filproject.admin.member.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filproject.admin.common.CommonUtil;
import com.filproject.admin.member.dao.AdminMemberDao;
import com.filproject.admin.member.service.AdminMemberService;

@Service
public class AdminMemberServiceImpl implements AdminMemberService {

	@Autowired
	private AdminMemberDao adminMemberDao;
	
	@Override
	public Map<String, Object> test() throws Exception {
		return adminMemberDao.test();
	}

	@Override
	public Map<String, Object> loginAjax(Map<String, Object> map) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String pw = (String) map.get("memPw");
		if (StringUtils.isEmpty(pw)) {
			throw new Exception("비밀번호 없음");
		}
		
		map.put("memPw", CommonUtil.setSHA256(pw));
		int cnt = adminMemberDao.selectMemberCnt(map);
		if (cnt == 1) {
			resultMap.put("success", "Y");
		} else {
			resultMap.put("success", "N");
		}
		return resultMap;
	}

}
