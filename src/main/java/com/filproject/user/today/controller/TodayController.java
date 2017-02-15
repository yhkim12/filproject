package com.filproject.user.today.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodayController {

	@RequestMapping(value={"/", "/login"})
	public String login() {
		
		return "login";
	}
}
