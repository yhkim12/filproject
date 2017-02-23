package com.filproject.common.security;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
 
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {

    	List<GrantedAuthority> authorities = (List<GrantedAuthority>) auth.getAuthorities();
    	String strAuth = authorities.get(0).getAuthority();
    	
    	ObjectMapper om = new ObjectMapper();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", "Y");
		
		if (strAuth.equals("admin")) {
			map.put("returnUrl", "/admin/member/list");
		} else {
			map.put("returnUrl", "/user/today/list");
		}

		String jsonString = om.writeValueAsString(map);

		OutputStream out = response.getOutputStream();
		out.write(jsonString.getBytes());
        
    }
 
 
}