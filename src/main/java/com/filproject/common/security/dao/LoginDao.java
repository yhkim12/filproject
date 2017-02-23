package com.filproject.common.security.dao;


import org.springframework.stereotype.Repository;

import com.filproject.common.security.vo.UserVO;

@Repository
public interface LoginDao {

	UserVO selectUserInfo(String id);

}
