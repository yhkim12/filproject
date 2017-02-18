package com.filproject.user.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filproject.user.member.dao.MemberDao;
import com.filproject.user.member.service.MemberService;

/**
 * 회원 관련 서비스 임플
 * @author dev-jjong
 *
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
}
