package com.filproject.user.today.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filproject.user.today.dao.TodayDao;
import com.filproject.user.today.service.TodayService;

@Service
public class TodayServiceImpl implements TodayService {
	
	@Autowired
	private TodayDao todayDao;
	
	@Override
	public Map<String, Object> todayList() throws Exception {
		return todayDao.todayList();
	}

}
