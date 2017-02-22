package com.filproject.common.security;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

 
public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private UserVO userVO;
    
    public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public CustomUserDetails(UserVO userVO) {
        // TODO Auto-generated constructor stub
        this.userVO = userVO;
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(userVO.getAuth()));
        return authorities;
    }
 
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.userVO.getMemPw();
    }
 
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.userVO.getMemId();
    }
 
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
 
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
 
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
 
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
 }