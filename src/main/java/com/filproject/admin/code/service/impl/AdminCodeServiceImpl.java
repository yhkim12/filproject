package com.filproject.admin.code.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import com.filproject.admin.code.dao.AdminCodeDao;
import com.filproject.admin.code.service.AdminCodeService;
import com.filproject.admin.common.Constant;

@Service
public class AdminCodeServiceImpl implements AdminCodeService {

	@Autowired
	private AdminCodeDao adminCodeDao;
	
	@Autowired
	private MessageSourceAccessor mr;

	@Override
	public Map<String, Object> codeList(Map<String, Object> map) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String currentPage = "0";
		if (map.get("currentPage") != null) {
			currentPage = (String) map.get("currentPage");
		}
		
		map.put("currentPage", currentPage);
		map.put("recordsPerPage", Constant.PAGING);
		resultMap.put("totalRecordCount", adminCodeDao.codeListCnt(map));
		resultMap.put("codeList", adminCodeDao.codeList(map));
		resultMap.put("currentPage", ("0".equals(currentPage) ? "1" : currentPage)); // 현재 페이지
		resultMap.put("recordsPerPage", Constant.PAGING); // 페이지 개수
		
		return resultMap;
	}
	
}
