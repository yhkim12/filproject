package com.filproject.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.filproject.common.security.dao.LoginDao;
import com.filproject.common.security.vo.UserVO;


public class CustomUserDetailService implements UserDetailsService {
	 
	@Autowired
    private LoginDao loginDao;
    
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    	UserVO userVO = loginDao.selectUserInfo(id);
        return new CustomUserDetails(userVO);
    }
	    
}