package com.filproject.admin.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AdminCommonInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AdminCommonInterceptor.class);

	@Autowired
	private MessageSourceAccessor mr;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

		
		
		//
		request.setAttribute("msg", mr.getMessage("msg.common.test"));

		return true;
	}

}