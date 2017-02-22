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

    	System.out.println(auth.getAuthorities().getClass().getName());
      
    	List<GrantedAuthority> authorities = (List<GrantedAuthority>) auth.getAuthorities();
    	String strAuth = authorities.get(0).getAuthority();
    	
    	ObjectMapper om = new ObjectMapper();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		if (strAuth.equals("ROLE_ADMIN")) {
			map.put("returnUrl", "/admin/admin.do");
		} else {
			map.put("returnUrl", "/user/user.do");
		}

		// {"success" : true, "returnUrl" : "..."}
		String jsonString = om.writeValueAsString(map);

		OutputStream out = response.getOutputStream();
		out.write(jsonString.getBytes());
        
    }
 
 
}