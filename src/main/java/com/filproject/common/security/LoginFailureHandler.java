package com.filproject.common.security;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailureHandler implements AuthenticationFailureHandler
{
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException
    {
    	ObjectMapper om = new ObjectMapper();

		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("exception.getMessage() :: "+exception.getMessage());
		map.put("success", "N");
		map.put("message", exception.getMessage());

		String jsonString = om.writeValueAsString(map);

		OutputStream out = response.getOutputStream();
		out.write(jsonString.getBytes(Charset.forName("UTF-8")));
		
    }
}