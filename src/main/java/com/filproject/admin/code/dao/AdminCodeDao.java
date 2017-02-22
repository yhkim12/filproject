package com.filproject.admin.code.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminCodeDao {

	Map<String, Object> test() throws Exception;

	int selectMemberCnt(Map<String, Object> map) throws Exception;

}
