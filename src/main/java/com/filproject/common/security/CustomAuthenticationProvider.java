package com.filproject.common.security;

import java.util.ArrayList;

import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class CustomAuthenticationProvider extends DaoAuthenticationProvider { 
      
//    @Override
//    public Authentication authenticate(Authentication auth) throws AuthenticationException {
//        return super.authenticate(auth);
//    }
     

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder; 

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
  
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	
        String user_id = (String)authentication.getPrincipal();    
        String user_pw = (String)authentication.getCredentials();
         
        //logger.info("사용자가 입력한 로그인정보입니다. {}", user_id + "/" + user_pw);
        System.out.println("사용자가 입력한 로그인정보입니다. " + user_id + "/" + user_pw);
        
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(user_id);
        
        if (userDetails.getUserVO() != null) {
        	if (passwordEncoder.matches(user_pw, userDetails.getUserVO().getMemPw())) {
                return new UsernamePasswordAuthenticationToken(userDetails, user_pw, userDetails.getAuthorities());
        	} else {
        		throw new BadCredentialsException("잘못된 비밀번호입니다.");
        	}
        } else {
	    	throw new UsernameNotFoundException("아이디가 없습니다.");
        }
    }
}