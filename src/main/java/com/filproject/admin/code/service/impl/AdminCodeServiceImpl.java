package com.filproject.admin.code.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filproject.admin.code.service.AdminCodeService;
import com.filproject.admin.common.CommonUtil;
import com.filproject.admin.member.dao.AdminMemberDao;
import com.filproject.admin.member.service.AdminMemberService;

@Service
public class AdminCodeServiceImpl implements AdminCodeService {

	@Autowired
	private AdminMemberDao adminMemberDao;

	@Override
	public Map<String, Object> codeList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
