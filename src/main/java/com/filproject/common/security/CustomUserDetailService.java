package com.filproject.common.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailService implements UserDetailsService {
	 
//		@Autowired
//	    private LoginDAO loginDAO;
	    
	    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
	    	//LoginVO loginVO = loginDAO.selectUser(id);
	        //return new CustomUserDetails(loginVO);
	    	return null;
	    }
}