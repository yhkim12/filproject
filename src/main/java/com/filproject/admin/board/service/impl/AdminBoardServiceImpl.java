package com.filproject.admin.board.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filproject.admin.board.dao.AdminBoardDao;
import com.filproject.admin.board.service.AdminBoardService;
import com.filproject.admin.common.CommonUtil;
import com.filproject.admin.member.dao.AdminMemberDao;
import com.filproject.admin.member.service.AdminMemberService;

@Service
public class AdminBoardServiceImpl implements AdminBoardService {

	@Autowired
	private AdminBoardDao adminBoardDao;
	

}
