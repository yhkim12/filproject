package com.filproject.admin.code.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminCodeDao {

	List<Map<String, String>> codeList(Map<String, Object> map) throws Exception;

	int codeListCnt(Map<String, Object> map) throws Exception;

}
