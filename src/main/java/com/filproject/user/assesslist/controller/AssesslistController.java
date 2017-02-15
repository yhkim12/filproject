package com.filproject.user.assesslist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AssesslistController {

	@RequestMapping(value={"/", "/login"})
	public String login() {
		
		return "login";
	}
}
