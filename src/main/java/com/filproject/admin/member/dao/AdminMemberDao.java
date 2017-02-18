package com.filproject.admin.member.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminMemberDao {

	Map<String, Object> test() throws Exception;

	int selectMemberCnt(Map<String, Object> map) throws Exception;

}
