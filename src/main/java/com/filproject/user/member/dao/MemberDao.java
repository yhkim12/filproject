package com.filproject.user.member.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * 회원 관련 DAO
 * @author dev-jjong
 *
 */
@Repository
public interface MemberDao {
	
	int selectMemberCnt(Map<String, Object> map) throws Exception;
}
