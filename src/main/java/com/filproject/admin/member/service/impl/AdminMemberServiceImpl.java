package com.filproject.admin.member.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
