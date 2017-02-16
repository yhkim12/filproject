package com.filproject.user.member.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("MemberDao")
public class  MemberDao extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public Map<String, Object> memSelect(Map<String, Object> paramMap){
		return (Map<String,Object>) memberDetail("dev.memSelect",paramMap);
	}

	public int memInsert(Map<String, Object> paramMap){
		int result = insert("dev.memInsert", paramMap);
		return result;
	}

	public void memUpdate(Map<String, Object> paramMap){
		update("dev.memUpdate", paramMap);
	}

	public void memDelete(Map<String, Object> paramMap){
		update("dev.memDelete", paramMap);
	}
	
	public Map<String, Object> checkId(Map<String, Object> paramMap){
		return (Map<String, Object>) checkId("dev.checkId", paramMap);
	}
	
	public Map<String, Object> memSearch(Map<String, Object> paramMap){
		return (Map<String, Object>) checkId("memSeach", paramMap);
	}

}