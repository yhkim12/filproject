package com.filproject.user.today.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface TodayDao{

	Map<String, Object> todayList() throws Exception;

}